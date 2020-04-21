package com.company.test.ThreadDome.syncchronizedTest;

import java.util.concurrent.TimeUnit;

public class SynchronizedTest5 {
    public synchronized void get(aa a){
        System.out.println(Thread.currentThread().getName()+""+1);
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+""+2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class aa{
        public static synchronized void get(){
            System.out.println(Thread.currentThread().getName()+""+1);
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+""+2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        aa a=new aa();
        new Thread(()->{
            a.get();
        },"t1").start();
        new Thread(()->{
            aa.get();
        },"t2").start();
    }
}
