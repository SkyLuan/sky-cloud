package com.sky.cloud.framework;

import com.sky.cloud.framework.Service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {


    public static void main(String[] args) {


//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);


        applicationContext.getApplicationName();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.test();


    }

}
