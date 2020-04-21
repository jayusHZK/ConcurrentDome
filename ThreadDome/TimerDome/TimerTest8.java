package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//使用Timer.schedule(TimerTask,long,long)隔long后 每隔long就执行一次任务
public class TimerTest8 {
    static Timer timer=new Timer();
    static class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    public static void main(String[] args) {
        MyTask t=new MyTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 13:45:34";
        try {
            Date dateRef=sdf.parse(dateString);
            timer.schedule(t,2000,1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
