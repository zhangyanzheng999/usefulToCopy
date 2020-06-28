package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/18-21:47
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        return "nacos registry,serverPort:"+serverPort+"\t id:"+id;
    }
}
