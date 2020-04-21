package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    //屏障，当一条线程完成用屏障让其阻塞，直到所有所有屏障生成
    static CyclicBarrier c=new CyclicBarrier(2);//指定屏障数量 线程调用1次await()告诉CyclicBarrier生成一种屏障了

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(11111);
                try {
                    c.await();
                    System.out.println(101);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("222222");
        c.await(); //阻塞
        System.out.println(3333);
        c.reset();

    }
}
