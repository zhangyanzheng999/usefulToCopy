package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术和ES交互
 * 1.Jest  默认不生效，需要导入Jest
 * 2.SpringData ElasticSearch
 *      1.Client  节点信息clusterNodes clusterName
 *      2.ElasticsearchTemplate 操作es
 *      3.编写一个ElasticsearchRepository的子接口
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
