package com.company.test.ThreadDome.Singleton;

public class SingletonByEnum2 {
    public enum mySing{
        SING;
        private String name;
        private mySing(){
            name="aa";
        }
        public String getName(){
            return name;
        }
    }
    public String getName(){
        return mySing.SING.getName();
    }
}
