package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.dao.CompanyRoleDao;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.entity.CompanyRole;
import com.boss.bes.system.manage.service.CompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:公司角色的业务类实现层
 * @author:zyz
 * @time:2020/7/16-15:15
 */
@Service
public class CompanyRoleServiceImpl implements CompanyRoleService {
    @Autowired
    CompanyRoleDao companyRoleDao;

    /**
     * 这个为了更新或者新增公司角色信息
     * @param update   是否更新
     * @param companyList  公司列表
     * @param roleId  角色Id
     */
    @Transactional
    @Override
    public void updateCompanyRole(Boolean update, List<Company> companyList, Long roleId) {
        //更新要先删除
        if (update) {
            Example example = new Example(CompanyRole.class);
            example.createCriteria().andEqualTo("roleId", roleId);
            int result = companyRoleDao.getListByExample(example).size();
            if (companyRoleDao.delete(example) != result) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_COMPANY_ROLE_UPDATE_EXCEPTION);
            }
        }
        //开始操作新的
        CompanyRole companyRole;
        for (Company company : companyList) {
            companyRole = new CompanyRole(company.getId(), roleId);
            // 保存失败需要抛出异常回滚
            if (companyRoleDao.save(companyRole) == 0) {
                throw new DaoException(SystemManageCodeEnum.SYSTEM_MANAGE_COMPANY_ROLE_UPDATE_EXCEPTION);
            }
        }
    }

}
