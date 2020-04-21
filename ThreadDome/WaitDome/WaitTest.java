package com.company.test.ThreadDome.WaitDome;

import org.omg.CORBA.ARG_OUT;

import java.net.SocketTimeoutException;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            System.out.println(1);
            try {
                Thread.currentThread().notifyAll();
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);

        });
        System.out.println();
        t1.start();
        System.out.println("main1");
        Thread.currentThread().notifyAll();
        Thread.currentThread().wait();
        System.out.println("main2");
    }
}
