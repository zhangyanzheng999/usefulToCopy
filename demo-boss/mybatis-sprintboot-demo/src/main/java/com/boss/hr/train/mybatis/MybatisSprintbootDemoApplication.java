package com.boss.hr.train.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.boss.hr.train.mybatis.dao")
@SpringBootApplication
public class MybatisSprintbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSprintbootDemoApplication.class, args);
    }

}
