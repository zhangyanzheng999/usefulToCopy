package com.bosssoft.hr.train.springboot.basic.example.service.impl;

import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractRoleDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractUserDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.RoleMapper;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.UserMapper;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.UserDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Role;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.User;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.RoleQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.UserQuery;
import com.bosssoft.hr.train.springboot.basic.example.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseCURDService<UserDTO, User,UserQuery, UserMapper> {

    @Autowired
    public UserServiceImpl(AbstractUserDao<User,UserMapper> userDao) {
        this.myDao = userDao;
    }

    @Override
    public List<?> query(UserQuery query) {
        return null;
    }

    @Override
    protected User doObjectTransf(UserDTO dto) {
        return null;
    }
}
