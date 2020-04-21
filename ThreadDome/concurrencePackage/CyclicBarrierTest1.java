package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest1 {
    //CyclicBarrier高级用法   传入线程类  让CyclicBarrier放行后优先执行线程类方法
    static CyclicBarrier c=new CyclicBarrier(2,new T());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111111);
                try {
                    c.await();
                    System.out.println(3333333);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(22222);
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    static class T implements Runnable{
        @Override
        public void run() {
            System.out.println("我是线程T");
        }
    }
}
