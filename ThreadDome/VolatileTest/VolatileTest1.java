package com.company.test.ThreadDome.VolatileTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class VolatileTest1 {
    static /*volatile*/ int num=0;
    static CountDownLatch c=new CountDownLatch(10);
    static CyclicBarrier cb=new CyclicBarrier(11);
    public void add(){

    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<1000;j++){
                    num++;
                }
                //c.countDown();
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cb.await();
        System.out.println(num);
    }
}
