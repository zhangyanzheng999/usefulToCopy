package com.boss.bes.system.manage.dao.impl;


import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.CompanyMapper;
import com.boss.bes.system.manage.pojo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:公司dao的具体实现类
 * @author:zyz
 * @time:2020/7/7-9:23
 */
@Repository
public class CompanyDaoImpl extends AbstractCompanyDao {
    @Autowired
    CompanyMapper companyMapper;


    /**
     * 用到了联级查询
     *
     * @param id
     * @param version
     * @return
     */
    @Override
    public Company query(Long id, Long version) {
        try {
            return companyMapper.getCompany(id, version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 公司的分页查询
     *
     * @param name
     * @param orgId
     * @return
     */
    @Override
    public List<Company> getCompanyWithOrg(String name, Long orgId) {
        try {
            return this.myMapper.getCompanyWithOrg(name, orgId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    /**
     * 根据id拿到公司名字
     *
     * @param id
     * @return
     */
    @Override
    public String getCompanyNameById(Long id) {
        try {
            return companyMapper.getCompanyName(id);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }
}
