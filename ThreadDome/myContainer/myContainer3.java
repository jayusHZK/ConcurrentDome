package com.company.test.ThreadDome.myContainer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 一个同步容器get、put、getcount方法  10条线程消费 2条线程生产的阻塞调用
   使用lock和newCondition实现
   精确指定叫醒生产者或消费者线程 */
public class myContainer3<T> {
    private final LinkedList<T> list=new LinkedList<>();  //创建容器
    final private int max=10;  // 个数最大值
    private int count=0; //元素个数

    private Lock lock=new ReentrantLock();
    private Condition producer =lock.newCondition();
    private Condition consumer=lock.newCondition();

    public  void put(T t) {
        try {
        lock.lock();
        while (list.size()==max){ //多线程  if执行是会有其他线程插入进行操作
            try {
               producer.await(); //如果容器满了 则让生产者线程等着  释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        consumer.signalAll();//通知所有消费者线程消费  不释放锁
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public synchronized T get(){
        T t1=null;
        lock.lock();
        try {
        while (list.size()==0){  //容器里面没数据
            try {
                consumer.await();  //消费者等着
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t1=list.removeFirst();
        count--;
        producer.signalAll(); //通知生产者生产
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t1;
    }

    public static void main(String[] args) {
        myContainer3<String> c=new myContainer3<>();
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
