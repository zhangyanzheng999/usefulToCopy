package com.bosssoft.hr.train.spring.service;

import com.bosssoft.hr.train.spring.bean.User;


import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--20:22
 */

public interface UserService {
    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 通过名字模糊搜索
     *
     * @param name
     */
    List<User> queryUsers(String name);

    /**
     * 批量删除,变长参数
     */
    int deleteByArray(int... ids);

}
