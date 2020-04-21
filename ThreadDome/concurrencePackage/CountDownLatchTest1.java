package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest1 {
    private static final ThreadPoolExecutor threadPool=new ThreadPoolExecutor(4,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    static CountDownLatch c=new CountDownLatch(4);
    static class GoThread extends Thread{
        private String name;
        public GoThread(String name){
            this.name=name;
        }
        public void run(){
            System.out.println(name+"到了");
            c.countDown();
        }
    }

    public static void main(String[] args) {
        String[] arr={"a","b","c","d"};
        for (int i=0;i<4;i++){
            new GoThread(arr[i]).run();
        }
    }
}
