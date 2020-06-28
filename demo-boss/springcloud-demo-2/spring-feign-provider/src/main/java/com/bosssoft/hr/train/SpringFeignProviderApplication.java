package com.bosssoft.hr.train;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;


@EnableDiscoveryClient
@EnableEurekaServer
public class SpringFeignProviderApplication {

    public static void main(String[] args) {
        //读取控制台避免端口冲突
        System.out.println("多个实例请输入不同端口号,请输入启动端口号");
        Scanner sc = new Scanner(System.in);
        String port = sc.nextLine();

        new SpringApplicationBuilder(SpringFeignProviderApplication.class)
                .properties("server.port=" + port).run(args);
    }

}
