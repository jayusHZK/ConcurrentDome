package com.company.test.ThreadDome.ReadWriteLockDome;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//写读互斥
public class ReadWriteLockTest4 {
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    public void read(){
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }
    public void write(){
        rwl.writeLock().lock();
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockTest4 rw=new ReadWriteLockTest4();
        new Thread(rw::write,"t1").start();
        new Thread(rw::read,"t2").start();
    }
}
