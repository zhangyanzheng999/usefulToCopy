package com.bosssoft.hr.train.springboot.basic.example.service.impl;

import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractBaseDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractRoleDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.RoleDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.RoleDaoImpl;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.RoleMapper;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Role;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.RoleQuery;
import com.bosssoft.hr.train.springboot.basic.example.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseCURDService<RoleDTO, Role,RoleQuery,RoleMapper> {

    @Autowired
    public RoleServiceImpl( AbstractRoleDao<Role,RoleMapper,RoleQuery> roleDao) {
        this.myDao = roleDao;
    }

    @Override
    public List<RoleDTO> query(RoleQuery query) {

        return null;
    }

    @Override
    protected Role doObjectTransf(RoleDTO dto) {
        return null;
    }

}
