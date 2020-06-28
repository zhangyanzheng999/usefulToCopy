package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:用注解的方式来体现初始化过程
 * @author:zyz
 * @time:2020/6/4--15:16
 */

@Slf4j
@Service
public class UserServiceImplWithAnnotation implements UserService {

    public UserServiceImplWithAnnotation() {
        log.info("UserServiceImplWithAnnotation创建了");
    }

    @PostConstruct
    public void init() {

        log.info("UserServiceImplWithAnnotation通过注解的方式执行了init");
    }


    @PreDestroy
    public void destroy() {
        log.info("UserServiceImplWithAnnotation通过注解的方式执行了destroy");
    }


}
