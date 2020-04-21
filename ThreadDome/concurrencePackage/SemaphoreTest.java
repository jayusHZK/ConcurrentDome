package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool=Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s=new Semaphore(1);

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(1);
                    try {
                        s.acquire(); //获得
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("save data");
                        s.release();//释放
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        threadPool.shutdown();
    }
}
