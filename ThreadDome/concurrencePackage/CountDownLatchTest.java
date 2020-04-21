package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    //子线程调用了计数器次countDown() 则此CountDownLatch可以退出
    static CountDownLatch c=new CountDownLatch(3); //计数器 调用countDown()-1 0退出
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("11111111");
                c.countDown(); //计数器-1
                System.out.println(141);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2222");
                c.countDown();
                c.countDown();
            }
        }).start();
        c.await(); //当c计数器为0时，退出    这个可以不写
        //c.await(3,TimeUnit.SECONDS); //当子线程三秒后不释放资源 则自动释放
        System.out.println("3333");
    }
}
