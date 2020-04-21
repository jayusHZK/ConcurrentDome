package com.company.test.ThreadDome.Singleton;

public enum SingletonByEnum {
    SINGLETON;
    private String name;
    private SingletonByEnum(){
        name="aa";
    }
    public String getName(){
        return name;
    }
}
