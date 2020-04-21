package com.company.test.ThreadDome.myThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*  精灵线程池 任务窃取*/
public class myThreadPool3 {
    public static void main(String[] args) throws IOException {
        ExecutorService service= Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());;

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        System.in.read();//阻塞才可以看到结果
    }
    static class R implements Runnable{
        int time;
        R(int t){
            this.time=t;
        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time+""+Thread.currentThread().getName());
        }
    }
}
