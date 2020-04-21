package com.company.test.ThreadDome.ThreadLocal;

//设置ThreadLocal 的默认值
public class ThreadLocalTest2 {
    static class threadLocalT extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return "默认值";
        }
    }

    public static void main(String[] args) {
        threadLocalT tl=new threadLocalT();
        tl.set("asfsa");
        System.out.println(tl.get());
    }

}
