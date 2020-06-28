package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.service.ComputeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-19:32
 */
@RestController
public class ComputeController {

    @Autowired
    ComputeServiceClient computeServiceClient;

    @GetMapping("/add")
    public String compute(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return computeServiceClient.compute(a, b);
    }
}
