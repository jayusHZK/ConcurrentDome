package com.company.test.ThreadDome.ThreadLocal;

import java.util.concurrent.TimeUnit;

//ThreadLocal  线程本地变量  线程需要需自己创建
public class ThreadLocal1 {
    static ThreadLocal<person> tl=new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();
        new Thread(()->{
            try {

                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new person());
            System.out.println(tl.get().name);
        }).start();

    }

    static class person{
        String name="qiugou";
        /*public person(String name){
            this.name=name;
        }*/

    }
}
