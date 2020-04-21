package com.company.test.ThreadDome.StreamThreadDome;

import org.omg.DynamicAny._DynAnyFactoryStub;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

//字符流
public class StreamThreadTest2 {
    public static void main(String[] args) {
        PipedReader pr=new PipedReader();
        PipedWriter pw=new PipedWriter();
        try {
            pw.connect(pr); //建立连接
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t1=new Thread(()->{
            System.out.println("read:");
            char[] byteArr=new char[20];
            try {
                int arrLength=pr.read(byteArr);
                while (arrLength!=-1){
                    String newData=new String(byteArr,0,arrLength);
                    System.out.println(newData);
                    arrLength=pr.read(byteArr);
                }
                System.out.println();
                pr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
            System.out.println("write:");
                try {
                    for (int i=0;i<300;i++){
                        String outData=""+(i+1);
                    pw.write(outData);
                    System.out.println(outData);
                    }
                    System.out.println();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        });
        t1.start();
        t2.start();
    }
}
