package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest9 {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{
        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        myTask t=new myTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ss HH:mm:ss");
        String dateString="2020-4-5 13:34:23";
        try {
            Date dateRef=sdf.parse(dateString);
            timer.scheduleAtFixedRate(t,dateRef,1000);  //下一次任务执行时间 从上一次任务结束时算起
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
