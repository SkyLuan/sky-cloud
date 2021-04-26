package com.test.layout;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class Demo {

    public static void main(String[] args) {

        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());//查看对象内部信息
        System.out.println(GraphLayout.parseInstance(new Object()).toPrintable());//获取对象外部信息，包含引用的对象



    }
}
