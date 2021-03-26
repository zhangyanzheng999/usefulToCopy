package com.atguigu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Springboot02AmqpApplication {


    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
