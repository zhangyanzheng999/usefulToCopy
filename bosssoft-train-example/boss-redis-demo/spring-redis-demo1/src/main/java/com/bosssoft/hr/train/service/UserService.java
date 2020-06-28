package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.entity.User;

import java.util.List;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-17:57
 */
public interface UserService {
    /**
     * 查询全部，主要是为了缓存
     *
     * @return
     */
    Object findAll();

    /**
     * 通过id查找User
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
