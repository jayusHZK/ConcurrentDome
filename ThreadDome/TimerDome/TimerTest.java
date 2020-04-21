package com.company.test.ThreadDome.TimerDome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    static Timer timer=new Timer();
    static class myTask extends TimerTask{ //内部类     TimerTask新启了一条线程  不是守护线程
        @Override
        public void run() {
            System.out.println("task运行了"+new Date());
        }
    }

    public static void main(String[] args) {
        myTask task=new myTask();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString="2020-4-5 13:35:00";
        try {
            Date dateRef=sdf.parse(dateString);
            System.out.println("字符串时间"+dateRef.toLocaleString()+"当前时间"+new Date().toLocaleString());
            timer.schedule(task,dateRef);  //在dateref的时间执行 task的run方法里面的内容
            timer.schedule(task,dateRef);  //在dateref的时间执行 task的run方法里面的内容
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
