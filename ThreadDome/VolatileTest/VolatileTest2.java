package com.company.test.ThreadDome.VolatileTest;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest2 {
    static /*volatile*/ int num=0;
    void m(){
        for (int i=0;i<1000;i++)num++;
    }

    public static void main(String[] args) {
        VolatileTest2 v=new VolatileTest2();
        List<Thread> list=new ArrayList<Thread>();
        for (int i=0;i<10;i++){
            list.add(new Thread(v::m));
        }
        list.forEach((o)->o.start());
        list.forEach((o)-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(num);
    }
}
