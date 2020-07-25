package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends CommonMapper<Role> {
    /**
     * 分页查询,这个没有公司Id
     * @param name
     * @param orgId
     * @return
     */
    List<Role> getRoleWithPage(@Param("name") String name, @Param("orgId") Long orgId);

    /**
     * 按照公司Id查找
     * @param name
     * @param companyId
     * @return
     */
    List<Role> getRoleWithPageByCompanyId(@Param("name") String name,@Param("companyId") Long companyId);
    /**
     * query
     * @param id
     * @param version
     * @return
     */
    Role getRoleWithCompanyAndOrg(@Param("id") Long id, @Param("version") Long version);


    Role queryWithCompanyId(@Param("id") Long id, @Param("version") Long version,@Param("companyId") Long companyId);

    /**
     * 查询角色
     * @param id
     * @return
     */
    Role getRoleWithId(Long id);

    /**
     * 根据用户id查询用户的所有角色
     * @param userId
     * @return
     */
    List<Role> getRoleWithUserId(@Param("userId") Long userId,@Param("companyId") Long companyId);

    /**
     * 根据公司Id查出公司下的所有角色
     * @param companyId
     * @return
     */
    List<Role> getRoleWithCompanyId(Long companyId);


    Long generatorCode();
}