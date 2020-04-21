package com.company.test.ThreadDome.MsgSend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

//使用CyclicBarrier
public class MsgSendTest5 {
    static List<String> list=new ArrayList<>();
    static class cb implements Runnable{
        @Override
        public void run() {
            System.out.println("=5");
        }
    }
    public static void main(String[] args) {
        CyclicBarrier cb=new CyclicBarrier(1,new cb());  //利用CyclicBarrier的构造函数  当放行时，优先执行的线程。

        Thread t2=new Thread(()->{
            for (int i=0;i<10;i++){
                list.add("a");
                System.out.println(i);
                if(i==5){
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.start();
    }
}
