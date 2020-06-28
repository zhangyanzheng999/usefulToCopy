package com.bosssoft.hr.trian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bosssoft.hr.trian.db.dao")
public class SpringbootDemoBossApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoBossApplication.class, args);
    }

}
