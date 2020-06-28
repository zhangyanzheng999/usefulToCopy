package com.bosssoft.hr.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bosssoft.hr.train.dao")
public class SpringbootDemo1MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1MvcApplication.class, args);
    }

}
