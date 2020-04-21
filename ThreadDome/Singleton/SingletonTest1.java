package com.company.test.ThreadDome.Singleton;

//立即加载  饿汉模式
public class SingletonTest1 {
    private static  SingletonTest1 sing=new SingletonTest1();
    private SingletonTest1(){

    }
    public static SingletonTest1 getSing(){
        return sing;
    }
}
