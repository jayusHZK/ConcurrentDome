package com.company.test.ThreadDome.ProducerConsumerModel;

public class ProducerConsumerTest2 {

    public static void main(String[] args) {
        mm m=new mm();
        for (int i=0;i<10;i++){
            new Thread(()->{
                m.ma();
            }).start();
            new Thread(()->{
                m.mb();
            }).start();
        }

    }
    static class mm {
        volatile boolean is=false;
        synchronized void ma(){
            while (is==true){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(120);
            is=true;
            this.notifyAll();
        }
         synchronized void mb(){
            while (is==false){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(220);
            is=false;
            this.notifyAll();
        }
    }
}
