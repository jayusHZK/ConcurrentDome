package com.company.test.ThreadDome.ThreadGroupDome;

public class ThreadGroupTest1 {
    public static void main(String[] args) {
        ThreadGroup group=new ThreadGroup("group1");
        Runnable run=new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        };
        Runnable run1=new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        };
        Thread t1=new Thread(group,run);
        Thread t2=new Thread(group,run1);
        t1.start();
        t2.start();
        System.out.println("获得的线程数"+group.activeCount());
        System.out.println("线程组名"+group.getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
    }
}
