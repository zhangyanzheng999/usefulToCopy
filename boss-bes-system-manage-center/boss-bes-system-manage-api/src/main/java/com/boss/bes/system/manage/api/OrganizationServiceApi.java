package com.boss.bes.system.manage.api;


import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.OrganizationMapper;
import com.boss.bes.system.manage.pojo.dto.OrganizationDTO;
import com.boss.bes.system.manage.pojo.entity.Organization;
import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.boss.bes.system.manage.pojo.vo.OrganizationVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description: 提供组织机构的Api
 * @author:zyz
 * @time:2020/7/6-18:07
 */
public interface OrganizationServiceApi extends CommonCRUDApi<Organization, OrganizationDTO, OrganizationVO, BasePageQuery, OrganizationMapper> {

    @ApiOperation("查询全部组织机构  可以有Id")
    CommonResponse<List<OrganizationVO>> queryAll(CommonRequest<Long> commonRequest);

    @ApiOperation("查询全部组织机构组成树")
    CommonResponse<List<BaseTreeVO>> queryTree();


    @ApiOperation("根据id拿到组织名字")
    CommonResponse<String> getOrgName(Long id);
}
