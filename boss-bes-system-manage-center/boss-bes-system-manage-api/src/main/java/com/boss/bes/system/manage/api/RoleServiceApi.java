package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.RoleMapper;
import com.boss.bes.system.manage.pojo.dto.RoleDTO;
import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.query.RolePageQuery;
import com.boss.bes.system.manage.pojo.query.RoleQuery;
import com.boss.bes.system.manage.pojo.query.RoleTreeQuery;
import com.boss.bes.system.manage.pojo.vo.RoleVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import io.swagger.annotations.ApiOperation;


import java.util.List;

/**
 * @description:角色模块
 * @author:zyz
 * @time:2020/7/11-18:10
 */
public interface RoleServiceApi extends CommonCRUDApi<Role, RoleDTO, RoleVO, RolePageQuery, RoleMapper> {

    @ApiOperation("根据公司Id查找对应的角色")
    CommonResponse<List<RoleVO>> queryRoleByByCompanyId(Long companyId);

    @ApiOperation("根据不同的查询条件来进行不同的查询")
    CommonResponse<RoleVO> queryForRole(CommonRequest<RoleQuery> commonRequest);

    @ApiOperation("查询公司作为树展示,要分为有没有组织Id")
    CommonResponse<List<BaseTreeVO>> queryCompanyForTree(CommonRequest<RoleTreeQuery> commonRequest);

    @ApiOperation("生成角色工号")
    CommonResponse<Long> generatorCode();
}
