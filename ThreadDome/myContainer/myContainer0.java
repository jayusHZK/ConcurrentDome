package com.company.test.ThreadDome.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class myContainer0 {
    /*volatile static */
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Thread t1=new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(i);
                list.add("1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(()->{
            while (true){
                if(list.size()==5){
                    System.out.println("=5");
                    break;
                }
            }
        });
        t1.start();
        t2.start();
    }
}
