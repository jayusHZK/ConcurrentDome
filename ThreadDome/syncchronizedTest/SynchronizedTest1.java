package com.company.test.ThreadDome.syncchronizedTest;

//证明synchronized是可重入锁
public class SynchronizedTest1 {

    synchronized void serviceA(){
        System.out.println("a");
        serviceB();
    }
    synchronized void serviceB(){
        System.out.println("b");
        serviceC();
    }
    synchronized void serviceC(){
        System.out.println("c");
    }

    public static void main(String[] args) {
        SynchronizedTest1 s=new SynchronizedTest1();
        s.serviceA();
        CommontUtil.a=1;
        System.out.println(CommontUtil.a);
    }
}
