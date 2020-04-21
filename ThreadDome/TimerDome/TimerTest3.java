package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

//实验 timertask任务按队列执行  一个任务执行完 后继任务才可以执行
public class TimerTest3 {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{
        @Override
        public void run() {

            try {

                System.out.println("1"+new Date());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class myTask1 extends TimerTask{
        @Override
        public void run() {
            System.out.println("2"+new Date());
        }
    }

    public static void main(String[] args) {
        myTask t=new myTask();
        myTask1 t1=new myTask1();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 14:59:00";
        String dateString1="2020-4-5 14:59:00";
        try {
            Date dateRef=sdf.parse(dateString);
            Date dateRef1=sdf.parse(dateString1);
            System.out.println("字符串"+dateRef.toString()+"当前"+new Date());
            System.out.println("字符串"+dateRef1.toString()+"当前"+new Date());
            timer.schedule(t,dateRef);
            timer.schedule(t1,dateRef1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
