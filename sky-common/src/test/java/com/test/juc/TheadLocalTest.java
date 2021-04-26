package com.test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal的测试应用
 */
public class TheadLocalTest {

    ThreadLocal<String> tl = new ThreadLocal<>();
    InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();//子类可以拿到父类线程的变量


    public static void main(String[] args) {
        TheadLocalTest theadLocalTest = new TheadLocalTest();
        theadLocalTest.tl.set("ThreadLocal");
        theadLocalTest.inheritableThreadLocal.set("inheritableThreadLocal");
        ExecutorService executorService =  Executors.newFixedThreadPool(5);
        for (int i=0; i< 10;i++){
            executorService.execute(()->{
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "----" + theadLocalTest.tl.get());
                    System.out.println(Thread.currentThread().getName() + "----" + theadLocalTest.inheritableThreadLocal.get());
                    theadLocalTest.inheritableThreadLocal.set("inheritableThreadLocal-" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


        }//end of for
        executorService.shutdown();//线程执行完毕后关闭线程池
    }







}
