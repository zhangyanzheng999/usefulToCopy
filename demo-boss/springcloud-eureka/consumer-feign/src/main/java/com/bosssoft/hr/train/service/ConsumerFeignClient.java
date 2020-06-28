package com.bosssoft.hr.train.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-16:38
 */
@FeignClient("compute-service")
public interface ConsumerFeignClient {
    @GetMapping("/api/compute/add")
    String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
}
