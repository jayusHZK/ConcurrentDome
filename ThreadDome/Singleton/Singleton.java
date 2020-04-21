package com.company.test.ThreadDome.Singleton;
 /* 线程安全 懒加载的单例 */
public class Singleton {
    private Singleton(){
        System.out.println("初始化");
    }
    private static class Inner{ //因为是静态内部类  所以线程安全
        private static Singleton s=new Singleton();
    }
    public static Singleton getSongleton(){
        return Inner.s;
    }

     public static void main(String[] args) {
         Thread[] ths=new Thread[20];
         for (int i=0;i<ths.length;i++){
             ths[i]=new Thread(()->{
                 Singleton.getSongleton();
             });
         }
     }
}
