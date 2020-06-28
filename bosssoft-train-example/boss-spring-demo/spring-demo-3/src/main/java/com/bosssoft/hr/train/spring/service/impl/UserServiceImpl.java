package com.bosssoft.hr.train.spring.service.impl;

import com.bosssoft.hr.train.spring.bean.User;
import com.bosssoft.hr.train.spring.dao.UserDao;
import com.bosssoft.hr.train.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--10:21
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 如果有就不放入
     *
     * @param id
     * @return
     */
    @Cacheable(value = "context", key = "#id")
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    /**
     * 每次都要重新放入
     *
     * @param name
     * @return
     */
    @CachePut(value = "context", key = "#name")
    public List<User> getUsersLikeName(String name) {
        return userDao.getUsersLikeName(name);
    }

    /**
     * 添加
     *
     * @param user
     * @return
     */
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @CacheEvict(value = "context", key = "#id", allEntries = false)
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }


}
