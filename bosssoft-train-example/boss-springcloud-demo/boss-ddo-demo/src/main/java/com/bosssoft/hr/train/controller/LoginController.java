package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.User;
import com.bosssoft.hr.train.service.LoginService;
import com.bosssoft.hr.train.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:用来验证登录
 * @author:zyz
 * @time:2020/6/17-16:16
 */
@RestController

public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/login")
    public String getToken(@RequestParam("userName") String userName,
                           @RequestParam("userPassword") String userPassword) {
        User user = new User(userName, userPassword);
        Integer userId = loginService.checkUser(user);
        String cacheKey = "token:" + userId;
        if (userId != -1) {
            //先到redis拿
            Object result = redisTemplate.opsForValue().get(cacheKey);
            if (result != null) {
                //之所以这么做是为了重复获取时，保证key不会提前过期
                redisTemplate.opsForValue().set(result.toString(), cacheKey, 15, TimeUnit.MINUTES);
                return result.toString();
            } else {
                String token = JwtUtil.sign((long) userId);
                //放入
                redisTemplate.opsForValue().set(cacheKey, token, 15, TimeUnit.MINUTES);
                redisTemplate.opsForValue().set(token, cacheKey, 15, TimeUnit.MINUTES);
                return token;
            }
        }
        return null;
    }
}
