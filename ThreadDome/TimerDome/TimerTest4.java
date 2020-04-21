package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest4 {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("启动"+new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("休眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        myTask t=new myTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 15:06:00";
        try {
            Date dateRef=sdf.parse(dateString);
            System.out.println(new Date());
            timer.schedule(t,dateRef,1000);  //从date起 吗，每给3000毫秒 运行一次task
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
