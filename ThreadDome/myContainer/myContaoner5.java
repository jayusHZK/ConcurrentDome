package com.company.test.ThreadDome.myContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

//一个容器  线程1对容器进行增加 线程2监视线程1，当容器修改到一定大小时，发出提醒
public class myContaoner5 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        CountDownLatch cdl=new CountDownLatch(1);
        Thread t1=new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(i);
                list.add(i+"");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(list.size()==5){
                    cdl.countDown();
                }
            }
        });
        Thread t2=new Thread(()->{
            while(true){
                if(list.size()!=5){
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("=5");
                    break;
                }
            }
        });
        t2.start();
        Thread.sleep(1000);
        t1.start();
    }
}
