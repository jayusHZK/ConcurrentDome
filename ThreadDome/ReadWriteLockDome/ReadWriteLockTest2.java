package com.company.test.ThreadDome.ReadWriteLockDome;

import javax.xml.transform.Source;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//写锁
public class ReadWriteLockTest2 {
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
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
        ReadWriteLockTest2 rw=new ReadWriteLockTest2();
        new Thread(rw::write,"t1").start();
        new Thread(rw::write,"t2").start();
    }
}
