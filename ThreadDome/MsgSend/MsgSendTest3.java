package com.company.test.ThreadDome.MsgSend;

import java.util.ArrayList;
import java.util.List;

//使用wait/notify
public  class MsgSendTest3 {
    static List<String> list=new ArrayList<>();
    //static
    public static void main(String[] args) {
        Object o=new Object();
        Thread t1=new Thread(()->{
            synchronized (o){
                if (list.size()!=5){
                    try {
                        o.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("=5");
                o.notifyAll();
            }

        });
        Thread t2=new Thread(()->{
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    list.add("a");
                    if (list.size() == 5) {
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

}
