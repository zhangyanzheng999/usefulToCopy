package com.bosssoft.hr.train.springboot.basic.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bosssoft.hr.train.springboot.basic.example.dao.mapper")
public class TrainSpringbootBasicExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainSpringbootBasicExampleApplication.class, args);
    }

}
