package com.boss.bes.system.manage.service.impl;


import com.boss.bes.system.manage.dao.CompanyDao;
import com.boss.bes.system.manage.mapper.CompanyMapper;
import com.boss.bes.system.manage.pojo.dto.CompanyDTO;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.query.CompanyPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.CompanyTreeVO;
import com.boss.bes.system.manage.pojo.vo.CompanyVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.CompanyService;
import com.boss.bes.system.manage.service.OrgService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;


/**
 * @description:公司服务的具体实现Service
 * @author:zyz
 * @time:2020/7/7-9:21
 */
@Service
public class CompanyServiceImpl extends BaseCRUDService<Company, CompanyDTO, CompanyVO, CompanyPageQuery, CompanyMapper> implements CompanyService {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    OrgService orgService;

    @Override
    public PageInfo<CompanyVO> queryAllWithPageAndOrg(CompanyPageQuery companyPageQuery) {
        PageMethod.startPage(companyPageQuery.getPageNum(), companyPageQuery.getPageSize());
        List<Company> companies = companyDao.getCompanyWithOrg("%" + companyPageQuery.getName() + "%", companyPageQuery.getOrganizationId());
        PageInfo<Company> pageInfo = new PageInfo<>(companies, 5);
        return BeanUtil.convertPageInfo(pageInfo, CompanyVO.class);
    }

    @Override
    public Integer update(CompanyDTO dto) {
        Company company = BeanUtil.copyData(dto, Company.class);
        Example example = new Example(Company.class);
        example.createCriteria().
                andEqualTo("id", company.getId()).
                andEqualTo("version", company.getVersion());
        return this.myDao.update(company, example);
    }

    @Override
    public CompanyVO query(BaseQuery query) {
        Company company = companyDao.query(query.getId(), query.getVersion());
        return BeanUtil.copyData(company, CompanyVO.class);
    }

    @Override
    public List<CompanyVO> queryAll() {
        return BeanUtil.convertListToList(this.myDao.queryAll(), CompanyVO.class);
    }


    @Override
    public List<CompanyTreeVO> queryTree(Long orgId) {

        List<CompanyTreeVO> companyTreeVOS = BeanUtil.convertListToList(orgService.queryAll(orgId), CompanyTreeVO.class);

        for (CompanyTreeVO companyTreeVO : companyTreeVOS) {
            //只到公司
            companyTreeVO.setChildren(BeanUtil.convertListToList(companyDao.getCompanyWithOrg("%%", companyTreeVO.getId()), CompanyTreeVO.class));
        }

        return companyTreeVOS;
    }

    @Override
    public List<CompanyTreeVO> queryTree(BaseTreeQuery query) {
        if (query.getCompanyId() == null) {
            return queryTree(query.getOrganizationId());
        } else {
            return Arrays.asList(BeanUtil.copyData(this.myDao.getOneById(query.getCompanyId()), CompanyTreeVO.class));
        }
    }

    @Override
    public List<CompanyVO> queryCompanyByOrgId(Long orgId) {
        Example example = new Example(Company.class);
        example.createCriteria().andEqualTo("organizationId", orgId);
        List<Company> companies = this.myDao.getListByExample(example);
        return BeanUtil.convertListToList(companies, CompanyVO.class);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.myDao.getOneById(id);
    }


    @Override
    public List<CompanyVO> queryCompanyByOrgId(BaseTreeQuery query) {
        Example example = new Example(Company.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId", query.getOrganizationId());
        if (query.getCompanyId() != null) {
            criteria.andEqualTo("id", query.getCompanyId());
        }
        return BeanUtil.convertListToList(this.myDao.getListByExample(example), CompanyVO.class);
    }

    @Override
    public Boolean validateCode(String code) {
        Example example=new Example(Company.class);
        example.createCriteria().andEqualTo("code",code);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public Boolean validateName(String name) {
        Example example=new Example(Company.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public String getCompanyNameById(Long id) {
        return companyDao.getCompanyNameById(id);
    }
}
