package com.company.test.ThreadDome.concurrencePackage;

import java.util.concurrent.*;

public class CyclicBarrierTest2 {//CyclicBarrier  复用的使用
    private static final ThreadPoolExecutor threadPool=new ThreadPoolExecutor(4,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    private static CyclicBarrier c=new CyclicBarrier(4, new Runnable() {
        @Override
        public void run() {
            System.out.println("寝室四兄弟出发去球场");
        }
    });
    private static class GoThread extends Thread{  //内部类
        private final String name;
        public GoThread(String name){
            this.name=name;
        }
        public void run(){
            System.out.println(name+"从宿舍出发");
            try {
                c.await();
                System.out.println(name+"到楼下了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            String[] arr1={"a","b","c","d"};
            String[] arr2={"e","f","g","h"};
            for (int i=0;i<4;i++){
                threadPool.execute(new GoThread(arr1[i]));
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("四个人来到球场，复用CyclicBarrier");
            c.reset();
            for (int i=0;i<4;i++){
                threadPool.execute(new GoThread(arr2[i]));
            }
            threadPool.shutdown();//关闭线程池
        }
    }
}
