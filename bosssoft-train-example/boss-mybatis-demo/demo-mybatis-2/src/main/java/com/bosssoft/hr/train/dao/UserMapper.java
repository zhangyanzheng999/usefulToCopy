package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.bean.User;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--20:47
 */
public interface UserMapper {

    User getUserByIdWithCompany(Integer id);
    User getUserByIdWithRole(Integer id);
}
