package com.company.test.ThreadDome.Singleton;
//延迟加载  懒汉模式
public class SingletonTest2 {
    private static SingletonTest2 sing;
    private SingletonTest2(){

    }
    public static SingletonTest2 getSing(){
        if(sing==null){
            sing=new SingletonTest2();
        }
        return sing;
    }
}
