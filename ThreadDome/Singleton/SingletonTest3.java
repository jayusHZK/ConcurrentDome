package com.company.test.ThreadDome.Singleton;
//双重检查锁
public class SingletonTest3 {
    private static SingletonTest3 sing;
    private SingletonTest3(){

    }

    public static SingletonTest3 getSing() {
        if(sing==null){
            synchronized (SingletonTest3.class){
                if(sing==null){
                    sing=new SingletonTest3();
                }
            }
        }
        return sing;
    }
}
