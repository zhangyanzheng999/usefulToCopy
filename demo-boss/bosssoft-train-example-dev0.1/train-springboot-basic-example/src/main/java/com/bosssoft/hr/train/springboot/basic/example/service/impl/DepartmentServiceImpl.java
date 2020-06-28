package com.bosssoft.hr.train.springboot.basic.example.service.impl;

import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractDepartmentDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.impl.AbstractRoleDao;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.DepartmentMapper;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.RoleMapper;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.DepartmentDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Department;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.Role;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.DepartmentQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.RoleQuery;
import com.bosssoft.hr.train.springboot.basic.example.service.BaseCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseCURDService<DepartmentDTO, Department, DepartmentQuery, DepartmentMapper> {

    @Autowired
    public DepartmentServiceImpl(AbstractDepartmentDao<Department, DepartmentMapper, DepartmentQuery> departmentDao) {
        this.myDao = departmentDao;
    }

    @Override
    public List<?> query(DepartmentQuery query) {
        return null;
    }

    @Override
    protected Department doObjectTransf(DepartmentDTO dto) {
        return null;
    }
}
