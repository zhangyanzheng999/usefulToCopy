package com.bosssoft.hr.train.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-19:29
 */
@Component
@FeignClient(value = "compute-service",fallback = SchedualServiceHiHystric.class)
public interface ComputeServiceClient {

    @GetMapping("/api/compute/add")
    String compute(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
}
