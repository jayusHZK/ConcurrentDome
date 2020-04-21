package com.company.test.ThreadDome.myThreadPool;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 定时执行任务线程 */
public class myThreadPool4 {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },0,500, TimeUnit.MILLISECONDS);
    }
}
