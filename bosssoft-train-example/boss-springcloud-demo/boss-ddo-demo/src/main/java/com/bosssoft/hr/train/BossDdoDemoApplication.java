package com.bosssoft.hr.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.bosssoft.hr.train.dao")
@EnableCaching
@SpringBootApplication(exclude =  HibernateJpaAutoConfiguration.class)
@EnableDiscoveryClient
public class BossDdoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossDdoDemoApplication.class, args);
    }

}
