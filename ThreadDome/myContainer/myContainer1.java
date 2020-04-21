package com.company.test.ThreadDome.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//一个容器  线程1对容器进行增加 线程2监视线程1，当容器修改到一定大小时，发出提醒
public class myContainer1 {
    /*volatile*/ List list=new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
       myContainer1 c=new myContainer1();
       final Object lock=new Object();  //用作同步对象锁
       new Thread(()->{
           synchronized (lock){
               System.out.println("t2启动");
               if(c.size()!=5){
                   try {
                       lock.wait(); //让线程停止  让出线程锁
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               System.out.println("t2结束");
               lock.notify();//唤醒线程
           }
       },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1); //让线程休息一秒  sleep不会释放线程锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动");
            synchronized (lock){
                for (int i=0;i<10;i++){
                    c.add(new Object());
                    System.out.println("t1:" + i);
                    if (c.size() == 5) {
                        lock.notify();  //唤醒另一条线程
                        try {
                            lock.wait();  //让出锁  让另一条线程执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (Exception e){

                    }
                }
            }
        },"t1").start();
    }
}
