package com.company.test.ThreadDome.myReentrantlock1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*ReentrantLock必须手动释放锁 */
public class myReentrantlock1 {
    Lock lock=new ReentrantLock(); //子接口

    void m1(){
        lock.lock();//上锁  相当于synchronized(this)
        try {
            for (int i=0;i<5;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁  reentrantlock必须手动释放锁
        }
    }
    void m2(){
        lock.lock();
        System.out.println("t2");
        lock.unlock();
    }

    public static void main(String[] args) {
        myReentrantlock1 lock1=new myReentrantlock1();
        new Thread(lock1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(lock1::m2).start();
    }
}
