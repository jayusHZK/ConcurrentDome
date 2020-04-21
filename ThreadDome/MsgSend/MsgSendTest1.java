package com.company.test.ThreadDome.MsgSend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//暴力法
public class MsgSendTest1 {
    static List<String> list=new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            while(true){
                //System.out.println(Thread.currentThread().getName());
                if(list.size()==5){
                    System.out.println("=5");
                    break;
                }
            }
        },"t1");
        Thread t2=new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+""+i);

                list.add("a");
            }
        },"t2");
        t1.start();
        //TimeUnit.SECONDS.sleep(2);
        t2.start();
    }
}
