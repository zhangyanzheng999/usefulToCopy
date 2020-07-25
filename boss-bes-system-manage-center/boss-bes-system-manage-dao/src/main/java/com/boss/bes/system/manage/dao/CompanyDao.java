package com.boss.bes.system.manage.dao;


import com.boss.bes.system.manage.pojo.entity.Company;

import java.util.List;

/**
 * @description: 公司的操作
 * @author:zyz
 * @time:2020/7/7-9:22
 */
public interface CompanyDao {
    Company query(Long id, Long version);

    List<Company> getCompanyWithOrg(String name, Long orgId);

    String getCompanyNameById(Long id);
}
