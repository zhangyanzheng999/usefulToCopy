package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.mapper.CompanyRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:公司角色中间表的dao层实现类
 * @author:zyz
 * @time:2020/7/16-15:18
 */
@Repository
public class CompanyRoleDaoImpl extends AbstractCompanyRoleDao {
    @Autowired
    CompanyRoleMapper companyRoleMapper;


}
