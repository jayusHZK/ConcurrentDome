package com.company.test.ThreadDome.myThreadPool;

import java.util.concurrent.*;

public class ForkTest1 extends RecursiveTask<Integer>{
    private static int THRESHOLD=10;
    private int start;
    private int end;
    public ForkTest1(int s,int e){
        this.start=s;
        this.end=e;
    }
    @Override
    protected Integer compute() {
        int sum=0;
        if(end-start<=THRESHOLD){
            for (int i =start; i<=end;i++){
                sum+=i;
            }
        }else{
            int mid=(end+start)/2;
            ForkTest1 left=new ForkTest1(start,mid);
            ForkTest1 right=new ForkTest1(mid+1,end);
            left.fork();
            right.fork();
            int leftResult=left.join();
            int rightResult=right.join();
            sum=leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool fjp=new ForkJoinPool();
        ForkTest1 ft=new ForkTest1(1,100);
        ForkJoinTask<Integer> result = fjp.submit(ft);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
