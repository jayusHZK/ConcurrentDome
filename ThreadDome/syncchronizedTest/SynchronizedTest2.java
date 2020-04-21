package com.company.test.ThreadDome.syncchronizedTest;

//证明出现异常线程或释放锁
public class SynchronizedTest2 {
    public static int i;
    int j;
    public static  int getI(){
        return i;
    }
    public void a(){};
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
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            int i=5/0;
            s.serviceA();
        },"t1").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            s.serviceA();
        },"t2").start();
    }
}
