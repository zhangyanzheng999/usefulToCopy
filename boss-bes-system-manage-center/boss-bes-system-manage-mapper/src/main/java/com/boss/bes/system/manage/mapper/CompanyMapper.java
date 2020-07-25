package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公司类的Mapper，需要一个联级查询
 */
public interface CompanyMapper extends CommonMapper<Company> {
    List<Company> getCompanyWithOrg(@Param("name") String name, @Param("orgId") Long orgId);

    Company getCompany(@Param("id") Long id, @Param("version") Long version);

    String getCompanyName(Long id);

    Company getCompanyById(Long id);


    /**
     * 通过role_company表查询
     * @return
     */
    List<Company> getCompanyListByRole(Long roleId);

    /**
     * 通过公司Id查找组织Id
     * @param id
     * @return
     */
    Long getOrgIdByCompanyId(Long id);
}