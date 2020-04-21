package com.company.test.ThreadDome.MsgSend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//使用CountDownLatch
public class MsgSendTest4 {
    static List<String> list=new ArrayList<>();
    static CountDownLatch cdl=new CountDownLatch(4);

    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            if(list.size()!=5){
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("=5");
        });
        Thread t2=new Thread(()->{
           for (int i=0;i<10;i++){
               list.add("a");
               System.out.println(i);
               try {
                   TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               cdl.countDown();  //还可以设置CountDownLatch 为1 在等于5时 释放
           }
        });
        t1.start();
        t2.start();
    }
}
