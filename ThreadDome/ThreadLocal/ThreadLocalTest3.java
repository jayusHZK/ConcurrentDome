package com.company.test.ThreadDome.ThreadLocal;

import java.util.Date;

public class ThreadLocalTest3 {
    static class TLT extends ThreadLocal{
        /*@Override
        protected Object initialValue() {
            return new Date().getTime();
        }*/
    }
    static TLT tt=new TLT();
    public static void main(String[] args) {
        tt.set(1);  //此处的1  子线程获取不到
        new Thread(()->{

            for (int i=0;i<10;i++){
                System.out.println("t1"+tt.get());
            }
        }).start();
        System.out.println(tt.get());
    }
}
