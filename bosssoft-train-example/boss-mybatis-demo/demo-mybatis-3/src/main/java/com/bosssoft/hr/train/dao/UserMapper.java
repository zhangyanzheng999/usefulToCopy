package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--22:10
 */
public interface UserMapper {

    void insertUsers(@Param("users") List<User> users);


    List<User> selectUsersByCondition(User user);



    void updateUser(User user);

}
