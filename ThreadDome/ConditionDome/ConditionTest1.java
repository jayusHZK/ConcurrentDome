package com.company.test.ThreadDome.ConditionDome;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest1 {
    //static Lock lock=new ReentrantLock();
    static ReentrantLock lock=new ReentrantLock();
    static Condition condition=lock.newCondition();

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            lock.lock();
            System.out.println("t11");
            System.out.println(lock.getHoldCount());
            System.out.println(lock.getQueueLength());
            System.out.println(lock.getWaitQueueLength(condition));//0
            try {
                condition.await();
                System.out.println("t12");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread t2=new Thread(()->{
            lock.lock();
            System.out.println(lock.getWaitQueueLength(condition));//1
            System.out.println("t21");
                System.out.println("t22");
                condition.signal();
                lock.unlock();
        });
        t1.start();  //得保证t1在t2之前执行
        t2.start();
    }
}
