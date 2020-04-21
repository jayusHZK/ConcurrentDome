package com.company.test.ThreadDome.myContainer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* 一个同步容器get、put、getcount方法  10条线程消费 2条线程生产的阻塞调用
   使用wait和notifyAll实现 */
public class myContainer2<T> {
    private final LinkedList<T> list=new LinkedList<>();  //创建容器
    final private int max=10;  // 个数最大值
    private int count=0; //元素个数

    public synchronized void put(T t) {
        while (list.size()==max){ //多线程  if执行是会有其他线程插入进行操作
            try {
                this.wait(); //如果容器满了 则让生产者线程等着
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll();//通知所有消费者线程消费
    }
    public synchronized T get(){
        T t1=null;
        while (list.size()==0){  //容器里面没数据
            try {
                this.wait();  //消费者等着  释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t1=list.removeFirst();
        count--;
        this.notifyAll(); //通知生产者生产 不释放锁
        return t1;
    }

    public static void main(String[] args) {
        myContainer2<String> c=new myContainer2<>();
        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<5;j++) System.out.println("c------"+c.get());
            },"c"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<2;i++){
            new Thread(()->{
                for (int j=0;j<25;j++)  c.put(Thread.currentThread().getName()+""+j);
            },"p"+i).start();
        }
    }
}
