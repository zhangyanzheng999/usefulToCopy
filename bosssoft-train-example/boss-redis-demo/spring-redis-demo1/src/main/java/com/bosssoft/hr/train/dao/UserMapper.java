package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-17:54
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user")
    List<User> findAll();

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User getUserById(Integer id);
}
