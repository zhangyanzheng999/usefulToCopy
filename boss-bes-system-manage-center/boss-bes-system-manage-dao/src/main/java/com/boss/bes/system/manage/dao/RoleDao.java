package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.entity.Role;

import java.util.List;

/**
 * @description: 角色的dao层
 * @author:zyz
 * @time:2020/7/11-19:52
 */
public interface RoleDao {
    /**
     * 进行分页
     * 如果orgId不为null，就查询orgId，
     * 如果companyId不为null，就查询companyId，
     * 否则按照名字模糊搜索
     *
     * @param name      %+角色名+%
     * @param companyId 公司Id
     * @param orgId     组织Id
     * @return
     */
    List<Role> queryAllWithPageAndCompanyAndOrg(String name, Long companyId, Long orgId);


    /**
     * 根据公司Id查找
     * @param companyId
     * @return
     */
    List<Role> getRoleWithCompanyId(Long companyId);


    /**
     * 查询
     * @param id
     * @param version
     * @return
     */
    Role query(Long id,Long version);


    /**
     * 查询要有公司Id
     * @param id
     * @param version
     * @param companyId
     * @return
     */
    Role queryWithCompanyId(Long id,Long version,Long companyId);


    Long generatorCode();
}
