package com.boss.bes.system.manage.dao.impl;


import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.DepartmentMapper;
import com.boss.bes.system.manage.pojo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:部门dao的实现类
 * @author:zyz
 * @time:2020/7/9-16:49
 */
@Repository
public class DepartmentDaoImpl extends AbstractDepartmentDao {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department query(Long id, Long version) {
        try {
            return departmentMapper.getDepartment(id,version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    @Override
    public List<Department> queryAllWithPageAndCompany(String name, Long companyId,Long organizationId,Long parentId) {
        try {
            return departmentMapper.queryAllWithPageAndCompany(name, companyId,organizationId,parentId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }
}
