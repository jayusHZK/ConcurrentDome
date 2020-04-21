package com.company.test.ThreadDome.ReadWriteLockDome;

import sun.awt.SunToolkit;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写互斥
public class ReadWriteLockTest3 {
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
        ReadWriteLockTest3 rw=new ReadWriteLockTest3();
        new Thread(rw::read,"t1").start();
        new Thread(rw::write,"t2").start();
    }
}
