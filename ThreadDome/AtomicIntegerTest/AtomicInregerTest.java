package com.company.test.ThreadDome.AtomicIntegerTest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInregerTest {
    public static AtomicInteger a=new AtomicInteger(0);
    static volatile int b=0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            mm();
        });
        t1.start();
        t1.join();
        System.out.println(b+"---------");
    }
    public static void mm(){
        for (int i=0;i<1000;i++){
            Runnable run=new Runnable() {
                @Override
                public void run() {
                    //a.getAndIncrement();
                    b++;
                    //System.out.println(a);

                }
            };
            Thread t=new Thread(run);
            t.start();
        }
    }

}
