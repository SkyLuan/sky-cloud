package com.sky.cloud.demoamqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 马博士
 */
@EnableRabbit
@SpringBootApplication
public class DemoAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAmqpApplication.class, args);
    }

}
