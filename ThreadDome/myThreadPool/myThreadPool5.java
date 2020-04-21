package com.company.test.ThreadDome.myThreadPool;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 缓存线程池 */
public class myThreadPool5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i=1;i<2;i++){
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
            System.out.println(service);
            TimeUnit.SECONDS.sleep(80);
            System.out.println(service);
        }
    }


}
