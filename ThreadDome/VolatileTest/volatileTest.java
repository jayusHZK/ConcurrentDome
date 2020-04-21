package com.company.test.ThreadDome.VolatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class volatileTest {
    volatile boolean is=true;
    AtomicInteger num=new AtomicInteger(1);
    void m(){
        System.out.println("m:start");

        while (is){

        }
        System.out.println("m:end");
    }

    public static void main(String[] args) {
        volatileTest t=new volatileTest();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.is=false;

    }
}
