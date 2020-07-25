package com.boss.bes.system.manage.service;


import com.boss.bes.system.manage.pojo.query.RolePageQuery;
import com.boss.bes.system.manage.pojo.query.RoleQuery;
import com.boss.bes.system.manage.pojo.query.RoleTreeQuery;
import com.boss.bes.system.manage.pojo.vo.RoleVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:角色业务层
 * @author:zyz
 * @time:2020/7/11-19:56
 */
public interface RoleService {

    PageInfo<RoleVO> queryAllWithPageAndCompanyAndOrg(RolePageQuery rolePageQuery);

    /**
     * 这个为了根据公司Id，拿到对应的角色
     * @param companyId
     * @return
     */
    List<RoleVO> queryRoleByByCompanyId(Long companyId);


    RoleVO queryForRole(RoleQuery body);

    List<BaseTreeVO> queryCompanyForTree(RoleTreeQuery query);

    Long generatorCode();
}
