package com.company.test.ThreadDome.ThreadLocal;

import java.util.Date;

//使用InheritableThreadLocal 完成ThreadLocal值继承
public class ThreadLocalTest4 {
    static class TLT extends InheritableThreadLocal{
        /*@Override
        protected Object initialValue() {
            return new Date().getTime();
        }*/
        @Override
        protected Object childValue(Object parentValue) {
            return parentValue+"我是子线程修改";
        }
    }
    static TLT tt=new TLT();
    public static void main(String[] args) {
        tt.set(1);  //此处的1 子线程可以获得
        new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println("t1"+tt.get());
            }
        }).start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println("t2"+tt.get());
            }
        }).start();
        System.out.println(tt.get());
    }
}
