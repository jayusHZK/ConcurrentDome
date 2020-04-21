package com.company.test.ThreadDome.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//一个容器  线程1对容器进行增加 线程2监视线程1，当容器修改到一定大小时，发出提醒
public class myContainer6 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        ReentrantLock lock=new ReentrantLock();
        Condition c=lock.newCondition();
        Thread t1=new Thread(()->{
            lock.lock();
            for (int i=0;i<10;i++){
                System.out.println(i);
                list.add(i+"");
                if(list.size()==5){
                    c.signalAll();
                }
            }
            lock.unlock();
        });
        Thread t2=new Thread(()->{
            lock.lock();
            if(list.size()!=5){
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
                System.out.println("=5");
                lock.unlock();

        });
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}
