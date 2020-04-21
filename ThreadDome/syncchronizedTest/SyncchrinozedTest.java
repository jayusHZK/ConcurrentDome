package com.company.test.ThreadDome.syncchronizedTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SyncchrinozedTest implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer{
        //是否处于占用状态
        protected boolean isHeldExclusively(){
            return getState()==1;
        }
        // 当状态为0时  获取锁
        public boolean tryAcquire(int acquire){
            if(compareAndSetState(0,1)){ //cas算法 判断状态是不是为0  如果内存中值为0 则改为1
                setExclusiveOwnerThread(Thread.currentThread());//获得锁
                return true;
            }
            return false;
        }
        // 释放锁 将同步状态改0
        protected boolean tryRelease(int relearse){
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);//释放锁
            setState(0); //修改同步器
            return true;
        }
        // 监视器  线程的休眠和唤醒
        Condition newcondition(){
            return new ConditionObject();
            }
    }
    private final Sync sync=new Sync();
    @Override
    public void lock() {
        sync.acquire(1);//上锁
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);//释放锁
    }

    @Override
    public Condition newCondition() {
        return sync.newcondition();//往同步队列加
    }

    public static void main(String[] args) {
        boolean a=true;
    }

}
