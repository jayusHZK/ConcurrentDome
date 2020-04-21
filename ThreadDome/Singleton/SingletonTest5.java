package com.company.test.ThreadDome.Singleton;

//使用静态代码块
public class SingletonTest5 {
    private static SingletonTest5 sing=null;
    private SingletonTest5(){}
    static{
        sing=new SingletonTest5();
    }

    public static SingletonTest5 getSing() {
        return sing;
    }
}
