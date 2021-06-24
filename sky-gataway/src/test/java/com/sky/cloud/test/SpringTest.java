package com.sky.cloud.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        Object object = applicationContext.getBean("test");



    }

}
