package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 通过xml
 * @author:zyz
 * @time:2020/6/4--15:24
 */
@Slf4j
public class UserServiceImplWithXml implements UserService {
    public void init() {
        log.info("UserServiceImplWithXml通过xml的方式执行了init");
    }

    public void destroy() {
        log.info("UserServiceImplWithXml通过xml的方式执行了destroy");
    }

    public UserServiceImplWithXml() {
        log.info("UserServiceImplWithXml创建了");
    }
}
