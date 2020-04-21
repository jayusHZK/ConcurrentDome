package com.company.test.ThreadDome.myReentrantlock1;

import java.util.concurrent.locks.ReentrantLock;

public class myReentrantlock2 {
    //public static ReentrantLock lock=new ReentrantLock();//非公平锁
    public static ReentrantLock lock=new ReentrantLock(true);//公平锁   根据现场等待时长来获得锁  记录线程等待时间 效率低
    public void run(){
        for (int i=0;i<100;i++){
            lock.lock();//获得锁
            try {
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();//释放锁
            }
        }
    }

    public static void main(String[] args) {
        myReentrantlock2 lock2=new myReentrantlock2();
        new Thread(lock2::run).start();
        new Thread(lock2::run).start();
    }
}
