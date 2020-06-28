package com.bosssoft.hr.train.dao.mapper;

import com.bosssoft.hr.train.pojo.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/22-12:32
 */

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
    List<User> findUsersLikeName(String name);
}
