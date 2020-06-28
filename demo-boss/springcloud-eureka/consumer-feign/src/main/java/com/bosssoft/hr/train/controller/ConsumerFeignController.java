package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.service.ConsumerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-16:40
 */
@RestController
@RequestMapping("/api/feign/")
public class ConsumerFeignController {
    @Autowired
    ConsumerFeignClient consumerFeignClient;

    @GetMapping("/add")
    public String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b){
        return consumerFeignClient.add(a,b);
    }

}
