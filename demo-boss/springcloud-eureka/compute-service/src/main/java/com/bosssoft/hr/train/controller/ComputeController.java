package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-15:41
 */
@RestController
@RequestMapping("/api/compute/")
public class ComputeController {

    @GetMapping("/add")
    public String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b, HttpServletRequest request) {
        if (a == 0 && b == 0) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer r = a + b;
        return r + ":" + request.getRequestURL().toString();
    }


    @GetMapping("/test")
    public void test() {
        while (true) {
            System.out.println("test..............");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/getToken")
    public Map getToken() {
        //用户认证
        //...
        Long userId = System.currentTimeMillis();
        //返回令牌
        Map token = new HashMap();
        token.put("token", JwtUtil.sign(userId));
        token.put("userId", userId);
        return token;
    }
}
