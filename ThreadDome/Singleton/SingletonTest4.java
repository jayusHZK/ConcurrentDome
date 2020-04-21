package com.company.test.ThreadDome.Singleton;

import java.io.Serializable;

//序列化单例
public class SingletonTest4 implements Serializable {
    private static final long serialzableUID=888L;
    private static class MySing{
        private static SingletonTest4 sing=new SingletonTest4();
    }
    private SingletonTest4(){}
    public static SingletonTest4 getSing(){
        return MySing.sing;
    }
    protected Object readResolve(){
        return MySing.sing;
    }
}
