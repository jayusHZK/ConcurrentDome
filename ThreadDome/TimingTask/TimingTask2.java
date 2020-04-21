package com.company.test.ThreadDome.TimingTask;

import java.util.Timer;
import java.util.TimerTask;

public class TimingTask2 {
    public static void main(String[] args) {
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务启动");
            }
        };
        Timer timer=new Timer();
        long delay=2000;
        long inter=2*1000;
        timer.scheduleAtFixedRate(task,delay,inter);
    }
}
