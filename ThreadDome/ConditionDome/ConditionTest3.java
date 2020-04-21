package com.company.test.ThreadDome.ConditionDome;

import sun.awt.SunToolkit;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest3 {
    static Lock lock=new ReentrantLock();
    static Condition producer=lock.newCondition();
    static Condition consumer=lock.newCondition();
    static boolean is=false;
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i=0;i<10;i++){
            System.out.println("t1");
            lock.lock();
                try {
                    while (is==true){
                        producer.await();
                    }
                    System.out.println(1);
                    is=true;
                    consumer.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }}
        });
        Thread t2=new Thread(()->{
            for (int i=0;i<10;i++){
            lock.lock();
            try {
                while (is==false){
                    consumer.await();
                }
                System.out.println(2);
                is=false;
                producer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }}
        });
            t1.start();
            t2.start();





    }
}
