package com.bosssoft.hr.train.mapper;

import com.bosssoft.hr.train.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/13-21:22
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User getUserById(Integer id);
}
