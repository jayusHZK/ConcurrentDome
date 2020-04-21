package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest2 {
    static Timer timer=new Timer(true);  //将启动线程变为精灵(守护)线程  如果执行时间早于当前时间  则立即执行
    static class myTask extends TimerTask{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task启动"+new Date());
        }
    }

    public static void main(String[] args) {
        myTask task=new myTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 13:45:00";
        try {
            Date dateRef=sdf.parse(dateString);
            System.out.println("字符串时间"+dateRef.toLocaleString()+"当前时间"+new Date());
            timer.schedule(task,dateRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
