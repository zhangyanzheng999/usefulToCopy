package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.CompanyDTO;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.query.CompanyPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.CompanyTreeVO;
import com.boss.bes.system.manage.pojo.vo.CompanyVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/7-9:21
 */
public interface CompanyService {
    /**
     * 批量删除
     *
     * @param companyDTOS
     * @return
     */
    Integer multiDelete(List<CompanyDTO> companyDTOS);


    /**
     * 根据组织id进行分页查询
     *
     * @param companyPageQuery
     * @return
     */
    PageInfo<CompanyVO> queryAllWithPageAndOrg(CompanyPageQuery companyPageQuery);

    /**
     * 查询全部公司，用来进行选择框
     *
     * @return
     */
    List<CompanyVO> queryAll();

    /**
     * 查询树
     *
     * @return
     */
    List<CompanyTreeVO> queryTree(Long orgId);

    List<CompanyTreeVO> queryTree(BaseTreeQuery query);

    /**
     * 通过组织Id拿到公司列表
     *
     * @param orgId
     * @return
     */
    List<CompanyVO> queryCompanyByOrgId(Long orgId);

    /**
     * 组织Id+公司Id去拿到公司，主要是为了解决当是公司时的问题，不在前端重复
     *
     * @param query
     * @return
     */
    List<CompanyVO> queryCompanyByOrgId(BaseTreeQuery query);

    Company getCompanyById(Long id);


    String getCompanyNameById(Long id);
}
