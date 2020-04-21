package com.company.test.ThreadDome.JoinDome;

import java.util.concurrent.TimeUnit;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main1");
        Thread t1=new Thread(()->{
            System.out.println(1);
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        //t1.join();
        t1.join(1000); //设置等待时间
        System.out.println("main2");
        new String();
    }
}
