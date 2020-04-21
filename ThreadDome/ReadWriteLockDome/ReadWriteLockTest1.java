package com.company.test.ThreadDome.ReadWriteLockDome;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读锁
public class ReadWriteLockTest1 {
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    public void read(){
        try {
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockTest1 rw=new ReadWriteLockTest1();
        Thread t1=new Thread(()->{
            rw.read();
        },"t1");
        Thread t2=new Thread(()->{
            rw.read();
        },"t2");
        t1.start();
        t2.start();
    }
}
