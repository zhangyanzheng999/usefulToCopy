package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-19:12
 */
@RestController
public class ComputeController {
    @Autowired
    ComputeService computeService;

    @GetMapping("/add/{a}/{b}")
    public String compute(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return computeService.compute(a, b);
    }



}
