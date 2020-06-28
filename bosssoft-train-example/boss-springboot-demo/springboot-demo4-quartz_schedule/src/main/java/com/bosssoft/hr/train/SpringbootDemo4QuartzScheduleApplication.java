package com.bosssoft.hr.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootDemo4QuartzScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo4QuartzScheduleApplication.class, args);
    }

}
