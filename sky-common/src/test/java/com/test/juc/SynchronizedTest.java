package com.test.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * synchronized并发锁
 * 锁对象，方法，代码块
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());//c
        System.out.println(ClassLayout.parseInstance(new Integer(0)).toPrintable());//c


    }
}
