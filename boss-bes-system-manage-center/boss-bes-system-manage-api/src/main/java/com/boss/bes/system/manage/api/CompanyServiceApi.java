package com.boss.bes.system.manage.api;


import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.CompanyMapper;
import com.boss.bes.system.manage.pojo.dto.CompanyDTO;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.query.CompanyPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.CompanyTreeVO;
import com.boss.bes.system.manage.pojo.vo.CompanyVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * @description:提供公司服务的Api
 * @author:zyz
 * @time:2020/7/6-19:42
 */
public interface CompanyServiceApi extends CommonCRUDApi<Company, CompanyDTO, CompanyVO, CompanyPageQuery, CompanyMapper> {
    @ApiOperation("查询全部公司")
    CommonResponse<List<CompanyVO>> queryAll();


    @ApiOperation("查询公司通过组织Id和公司Id")
    CommonResponse<List<CompanyVO>> queryCompanyByOrgId(CommonRequest<BaseTreeQuery> commonRequest);


    @ApiOperation("查询全部组织机+公司构组成树")
    CommonResponse<List<CompanyTreeVO>> queryTree(CommonRequest<BaseTreeQuery> commonRequest);



    String getCompanyNameById(Long id);


    CommonResponse<CompanyVO> queryCompanyById(CommonRequest<Long> commonRequest);
}
