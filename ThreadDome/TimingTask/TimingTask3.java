package com.company.test.ThreadDome.TimingTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimingTask3 {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务启动");
            }
        };
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();//单例
        service.scheduleAtFixedRate(runnable,2,1, TimeUnit.SECONDS);
    }
}
