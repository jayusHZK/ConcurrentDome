package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//使用timer.schedule(TimerTask,long) 从当前时间开始 隔long执行一次任务
public class TimerTest7 {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    public static void main(String[] args) {
        myTask t=new myTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 13:34:45";
        try {
            Date dateRef=sdf.parse(dateString);
            timer.schedule(t,1000); //没1000毫秒执行一次任务
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
