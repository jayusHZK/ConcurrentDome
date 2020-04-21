package com.company.test.ThreadDome.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

//一个容器  线程1对容器进行增加 线程2监视线程1，当容器修改到一定大小时，发出提醒
public class myContaoner4 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        final Thread t1=new Thread(()->{
            if(list.size()!=5){
                LockSupport.park();
            }
            System.out.println("=5");
        });
        final Thread t2=new Thread(()->{
            for (int i=0;i<10;i++){
                list.add(i+"");
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(list.size()==5){
                    LockSupport.unpark(t1);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
