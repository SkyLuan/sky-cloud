package com.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cdt.countDown();线程安全
 * cdt.await();阻塞等待，直到CountDown为0
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        int threadCount = 10;
        CountDownLatch cdt = new CountDownLatch(threadCount+1);//大于线程数量
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount+1);
        for(int i = 0; i< threadCount;i++){
            executorService.execute(()->{
                try {
                    lock.lock();
                    cdt.countDown();//CountDown-1
//                    cdt.await();//阻塞等待，直到CountDown为0再继续
                    System.out.println(Thread.currentThread().getName() + "===========cdt.await();=="+ cdt.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
        }
        System.out.println("===线程创建完毕==========");
        Thread.sleep(1000);
//        cdt.countDown();
        executorService.shutdown();//线程执行完了之后，关闭销毁
        System.out.println("===线程执行完毕==========" + cdt.getCount());
    }



}
