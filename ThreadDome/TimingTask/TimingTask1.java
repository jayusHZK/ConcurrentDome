package com.company.test.ThreadDome.TimingTask;

import java.util.concurrent.TimeUnit;

public class TimingTask1 {
    public static void main(String[] args) {
        final long timeInterval=1;
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (true){//也可以使用 for(;;)
                    System.out.println("定时任务启动");
                    try {
                        TimeUnit.SECONDS.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
        //使用thread  分割线   上下是两种不同的实现方式
        new Thread(()->{
            while (true){  //也可以使用 for(;;)
                System.out.println("定时任务thread");
                try {
                    TimeUnit.SECONDS.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"哈哈哈").start();
        //分割线
        Thread aa= new Thread(){
            @Override
            public void run() {
                System.out.println(123);
            }
        };
        aa.start();
    }

}
