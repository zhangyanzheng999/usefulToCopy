package com.bosssoft.hr.train.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/18-10:41
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${hztech}")
    String hztech;

    @Value("${test}")
    String test;
    @GetMapping("/hi")
    public String getHztech() {
        return hztech+"------>"+test;
    }

}
