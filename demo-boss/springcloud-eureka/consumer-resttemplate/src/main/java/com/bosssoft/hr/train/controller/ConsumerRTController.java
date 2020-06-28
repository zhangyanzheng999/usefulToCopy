package com.bosssoft.hr.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-16:27
 */
@RestController
@RequestMapping("/api/consumer/")
public class ConsumerRTController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(){
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/api/compute/add?a=10&b=20",String.class).getBody();
    }

}
