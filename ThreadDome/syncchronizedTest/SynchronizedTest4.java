package com.company.test.ThreadDome.syncchronizedTest;

import java.util.concurrent.TimeUnit;

public class SynchronizedTest4 {
    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+"m11");
        try {

            System.out.println(Thread.holdsLock(this));
            TimeUnit.SECONDS.sleep(1);

            System.out.println(Thread.currentThread().getName()+"m12");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void m2(){

        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"m21");
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+"m22");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest4 s=new SynchronizedTest4();
        new Thread(()->{
            s.m1();
        },"t1").start();
        new Thread(()->{
            s.m2();
        },"t2").start();
    }
}
