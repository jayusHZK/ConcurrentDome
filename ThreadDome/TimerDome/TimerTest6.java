package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//使用 timer.cancel()清空任务队列
public class TimerTest6 {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(1);
            timer.cancel();
        }
    }
    static class myTask1 extends TimerTask{
        @Override
        public void run() {
            System.out.println(2);
        }
    }

    public static void main(String[] args) {
        myTask t=new myTask();
        myTask1 t1=new myTask1();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 13:00:00";
        try {
            Date dateRef=sdf.parse(dateString);
            timer.schedule(t,dateRef,1000);
            timer.schedule(t1,dateRef,1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
