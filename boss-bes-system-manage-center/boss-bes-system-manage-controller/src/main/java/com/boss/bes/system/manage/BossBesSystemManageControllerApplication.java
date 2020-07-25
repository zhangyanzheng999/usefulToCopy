package com.boss.bes.system.manage;

import com.boss.config.MySwagger;
import com.boss.config.RedisInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@RedisInit
@MySwagger
@SpringBootApplication(scanBasePackages = "com.boss.bes.system.manage")
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.boss.bes.system.manage.mapper")
public class BossBesSystemManageControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossBesSystemManageControllerApplication.class, args);
    }

}
