package com.company.test.ThreadDome.ProducerConsumerModel;

public class ProducerConsumerTest1 {
    static String val="";

    public static void main(String[] args) {
        Object lock=new Object();
        Thread t1=new Thread(()->{  //生产者线程
            synchronized (lock){
                while (true){
                    if(!val.equals("")){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    val="1";
                    lock.notifyAll();
                }
            }
        });
        Thread t2=new Thread(()->{  //消费者线程
            synchronized (lock){
                while (true){
                    if(val.equals("")){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("val="+val);
                    lock.notifyAll();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
