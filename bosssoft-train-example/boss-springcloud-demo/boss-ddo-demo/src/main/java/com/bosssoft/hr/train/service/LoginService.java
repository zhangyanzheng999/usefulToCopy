package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.bean.User;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/17-16:26
 */
public interface LoginService {
    Integer checkUser(User user);
}
