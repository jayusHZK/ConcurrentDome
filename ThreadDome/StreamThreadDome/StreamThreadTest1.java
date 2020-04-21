package com.company.test.ThreadDome.StreamThreadDome;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//字节流
public class StreamThreadTest1 {
    public static void main(String[] args) {
        PipedInputStream pis=new PipedInputStream(); //输入
        PipedOutputStream pos=new PipedOutputStream();//输出
        try {
            pos.connect(pis); //建立连接
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t1=new Thread(()->{
            System.out.println("write");
                try {
                    for (int i=0;i<10;i++){
                        String outData=""+(i+1);
                    pos.write(outData.getBytes());
                    System.out.println(outData);
                    }
                    System.out.println();
                    pos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
        });
        Thread t2=new Thread(()->{
            System.out.println("read:");
            byte[] byteArr=new byte[20];
            try {
                int readLength=pis.read(byteArr);
                while (readLength!=-1){
                    String newData=new String(byteArr,0,readLength);
                    System.out.println("newData"+newData);
                    readLength=pis.read(byteArr);
                }
                System.out.println();
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
