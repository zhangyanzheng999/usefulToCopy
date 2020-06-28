package com.bosssoft.hr.train.spring.dao;

import com.bosssoft.hr.train.spring.bean.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/4--20:22
 */
public interface UserMapper {
    Integer insert(User user);

    Integer update(User user);

    Integer deleteById(Integer id);

    /**
     * 通过名字模糊搜索
     *
     * @param name
     */
    List<User> queryUsers(String name);

    /**
     * 批量删除
     */
    Integer deleteByArray(@Param("ids") int[] ids);
}
