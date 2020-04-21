package com.company.test.ThreadDome.myThreadPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/* 分片线程池 执行大任务 会将任务分成若干个小任务 最后结果汇总  递归*/
public class myThreadPool2 {
    static int[] nums=new int[1000000];
    static final int MAX_NUM=50000;
    static Random r=new Random();

    static{
        for (int i=0;i<nums.length;i++){
            nums[i]=r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
    }
    static class addTask extends RecursiveAction{
        int start,end;
        public addTask(int s,int e){
            start=s;
            end=e;
        }
        @Override
        protected void compute() {
            if(end-start<=MAX_NUM){
                long sum=0L;
                for (int i=start;i<end;i++) sum+=nums[i];
                System.out.println("from:"+start+"to"+end+"="+sum);
            }else{
                int mid=start+(end-start)/2;
                addTask subTask1=new addTask(start,mid);
                addTask subTask2=new addTask(mid,end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp=new ForkJoinPool();
        addTask task=new addTask(0,nums.length);
        fjp.execute(task);
        System.in.read();
    }
}