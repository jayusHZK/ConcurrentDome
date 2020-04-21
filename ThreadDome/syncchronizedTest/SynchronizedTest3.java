package com.company.test.ThreadDome.syncchronizedTest;

import java.util.concurrent.TimeUnit;

public class SynchronizedTest3 {
    Object o=new Object();
    public void aa(){
        System.out.println(Thread.currentThread().getName()+""+1);
        synchronized (this){
            System.out.println("sync--"+Thread.currentThread().getName());
        }
        synchronized (o){
            System.out.println("object--"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+""+2);
    }
    public void bb(){
        synchronized (o){
            System.out.println("object--"+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        SynchronizedTest3 s=new SynchronizedTest3();
        new Thread(()->{
            s.aa();
        },"t1").start();
        new Thread(()->{
            s.bb();
        },"t2").start();
    }
}
