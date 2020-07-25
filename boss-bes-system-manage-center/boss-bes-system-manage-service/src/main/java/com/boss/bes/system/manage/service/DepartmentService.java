package com.boss.bes.system.manage.service;


import com.boss.bes.system.manage.pojo.entity.Department;
import com.boss.bes.system.manage.pojo.query.DepartmentPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.DepartmentTreeVO;
import com.boss.bes.system.manage.pojo.vo.DepartmentVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description: 部门信息的业务处理器
 * @author:zyz
 * @time:2020/7/9-14:41
 */
public interface DepartmentService {
    /**
     * 分页查询
     * @param departmentPageQuery
     * @return
     */
    PageInfo<DepartmentVO> queryAllWithPageAndCompany(DepartmentPageQuery departmentPageQuery);

    /**
     * 为了生成所需部门但是排除自身
     * @param companyId
     * @param departmentId
     * @return
     */
    List<DepartmentVO> queryDepartmentByCompanyId(Long companyId, Long departmentId);

    /**
     * 通过公司Id查找部门,为了生成选择框
     * @param companyId
     * @return
     */
    List<DepartmentVO> queryDepartmentByCompanyId(Long companyId);

    /**
     * 查询树
     *
     * @return
     */
    List<DepartmentTreeVO> queryTree(BaseTreeQuery query);


}
