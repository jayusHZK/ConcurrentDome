package com.company.test.ThreadDome.YieldTest;

import sun.security.krb5.internal.TGSRep;

import java.util.concurrent.TimeUnit;

public class YieldTest {
    static class dome{
        public void aaa(){
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class test extends Thread{
        public dome d;
        public test(dome d){
            this.d=d;
        }
        @Override
        public void run() {
            d.aaa();

        }
    }
    static class test1 extends Thread{
        public dome d;
        public test1(dome d){
            this.d=d;
        }
        @Override
        public void run() {
            d.aaa();

        }
    }
    public static void main(String[] args) {
        dome d=new dome();
        dome d1=new dome();
        Thread t1=new test(d);
        Thread t2=new test1(d1);
        t1.start();
        t2.start();
    }
}
