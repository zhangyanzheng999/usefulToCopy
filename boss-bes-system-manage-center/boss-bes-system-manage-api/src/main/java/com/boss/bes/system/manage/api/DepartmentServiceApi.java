package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.DepartmentMapper;
import com.boss.bes.system.manage.pojo.dto.DepartmentDTO;
import com.boss.bes.system.manage.pojo.entity.Department;
import com.boss.bes.system.manage.pojo.query.DepartmentPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.DepartmentTreeVO;
import com.boss.bes.system.manage.pojo.vo.DepartmentVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:部门对外提供服务的接口
 * @author:zyz
 * @time:2020/7/9-14:39
 */
public interface DepartmentServiceApi extends CommonCRUDApi<Department, DepartmentDTO, DepartmentVO, DepartmentPageQuery, DepartmentMapper> {

    @ApiOperation("传入公司id和当前部门id，用来显示可用的上级部门")
    CommonResponse<List<DepartmentVO>> queryDepartmentByCompanyIdWithOutSelf(Long companyId, Long departmentId);

    @ApiOperation("查询全部组织机+公司+部门构组成树")
    CommonResponse<List<DepartmentTreeVO>> queryTree(CommonRequest<BaseTreeQuery> commonRequest);

    @ApiOperation("传入公司id用来显示可用的部门")
    CommonResponse<List<DepartmentVO>> queryDepartmentByCompanyId(Long companyId);

}
