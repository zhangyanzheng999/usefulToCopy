package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 插入
     * @param user
     * @return
     */
    int insetUser(User user);

    /**
     * 查找，按照名字模糊搜索
     * @param user
     * @return
     */
    List<User> queryUsers(User user);

    /**
     * 按照id删除
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

}
