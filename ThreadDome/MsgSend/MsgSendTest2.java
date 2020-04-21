package com.company.test.ThreadDome.MsgSend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//使用lock/condition
public class MsgSendTest2 {
    static List<String> list=new ArrayList<>();
    static ReentrantLock lock=new ReentrantLock();
    static Condition tc1=lock.newCondition();
    static Condition tc2=lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            lock.lock();
            System.out.println("t1");
            try {
                if(list.size()!=5) {
                    tc1.await(); //释放锁
                }
                System.out.println("=5");
                tc2.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        });
        Thread t2=new Thread(()->{
           lock.lock();
            try {
                 for (int i=0;i<10;i++) {
                     list.add("a");
                     System.out.println(i);
                     if (list.size() == 5) {
                         tc1.signalAll();
                         tc2.await();
                     }
                 }
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }finally {
                      lock.unlock();
                 }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
    }
}
