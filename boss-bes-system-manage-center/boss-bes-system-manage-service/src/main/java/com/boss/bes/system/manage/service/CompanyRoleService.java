package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.entity.Company;

import java.util.List;

/**
 * @description:公司角色的中间表
 * @author:zyz
 * @time:2020/7/16-15:15
 */
public interface CompanyRoleService {
    /**
     * 更新公司角色信息
     * @param update   是否更新
     * @param companyList  公司列表
     * @param roleId  角色Id
     */
    void updateCompanyRole(Boolean update, List<Company> companyList, Long roleId);
}
