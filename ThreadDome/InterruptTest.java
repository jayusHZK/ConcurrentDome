package com.company.test.ThreadDome;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        Thread t=new Thread(()->{
            while (Thread.currentThread().isInterrupted()){
                System.out.println("中断");
            }
            System.out.println(2222);
        },"t");
        t.start();
        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
        System.out.println(t.isInterrupted());
        //System.out.println(Thread.currentThread().isInterrupted());
    }
}
