package com.bosssoft.hr.train;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 注意MapperScan为tk.mybatis.spring.annotation.MapperScan
 */
@MapperScan("com.bosssoft.hr.train.dao")
@SpringBootApplication
public class TkMybaitsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMybaitsDemoApplication.class, args);
    }

}
