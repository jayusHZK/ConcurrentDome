package com.company.test.ThreadDome.concurrencePackage;

import java.sql.Time;
import java.util.concurrent.*;

public class ExchangerTest {
    private static final Exchanger<String> exgr=new Exchanger<String>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A="a";
                try {
                    try {
                        exgr.exchange(A,1, TimeUnit.SECONDS);
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B="b";
                /*try {
                    exgr.exchange(B);
                    String A=exgr.exchange(B);
                    System.out.println(2);
                    System.out.println(A.equals(B));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });
        threadPool.shutdown();
        System.out.println("over");
    }
}
