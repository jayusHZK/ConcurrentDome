package com.company.test.ThreadDome.myThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class myThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(5);//线程池 创建5条线程，需要时启动
        for (int i=0;i<6;i++){
            service.execute(()->{  //execute方法 往线程中丢任务
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);

        service.shutdown(); //线程池中的线程执行完毕关闭
        //service.shutdownNow();//不管线程池中的线程是否执行完毕 直接关闭
        System.out.println(service.isTerminated()); //任务是否已执行完
        System.out.println(service.isShutdown());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(2);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
