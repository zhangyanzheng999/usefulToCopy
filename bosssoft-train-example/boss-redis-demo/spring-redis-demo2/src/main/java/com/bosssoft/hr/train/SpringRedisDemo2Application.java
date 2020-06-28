package com.bosssoft.hr.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.bosssoft.hr.train.mapper")
@EnableCaching
@SpringBootApplication
public class SpringRedisDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisDemo2Application.class, args);
    }

}
