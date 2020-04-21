package com.company.test.ThreadDome.ConditionDome;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {
    static Lock lock=new ReentrantLock();
    static Condition producer=lock.newCondition();
    static Condition consumer=lock.newCondition();
    static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
        ConditionTest2 c=new ConditionTest2();
        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<10;j++)c.consumer();
            }).start();
        }
        for (int i=0;i<2;i++){
            new Thread(()->{
                for (int j=0;j<50;j++) c.producer();
            }).start();
        }

    }
    public void producer(){
        lock.lock();
        try {
            while (list.size()==10){
                producer.await();
            }
            list.add("abc");
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void consumer(){
        lock.lock();
        try {
            while (list.size()==0){
                consumer.await();
            }
            String aa=list.remove(0);
            System.out.println(aa);
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
