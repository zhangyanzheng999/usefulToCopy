package com.bosssoft.hr.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;

@SpringBootApplication
@Cacheable

public class SpringRedisParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisParentApplication.class, args);
    }

}
