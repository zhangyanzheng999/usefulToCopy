package com.boss.bes.system.manage.service.impl;


import com.boss.bes.system.manage.dao.OrgDao;
import com.boss.bes.system.manage.mapper.OrganizationMapper;
import com.boss.bes.system.manage.pojo.dto.OrganizationDTO;
import com.boss.bes.system.manage.pojo.entity.Organization;
import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.boss.bes.system.manage.pojo.vo.OrganizationVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.OrgService;
import com.boss.bes.system.manage.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:实现OrgService，关于组织机构的具体操作都在这里
 * @author:zyz
 * @time:2020/7/4-15:50
 */
@Service
public class OrgServiceImpl extends BaseCRUDService<Organization, OrganizationDTO, OrganizationVO, BasePageQuery, OrganizationMapper> implements OrgService {

    @Autowired
    OrgDao orgDao;

    /**
     * 进行查询全部
     *
     * @return
     */
    public List<OrganizationVO> queryAll(Long id) {
        List<Organization> organizationList = new ArrayList<>();
        if (id == null) {
            organizationList = this.myDao.queryAll();
        } else {
            organizationList.add(this.myDao.getOneById(id));
        }
        return BeanUtil.convertListToList(organizationList, OrganizationVO.class);
    }


    @Override
    public Integer update(OrganizationDTO organizationDTO) {
        Organization organization = BeanUtil.copyData(organizationDTO, Organization.class);
        Example example = new Example(Organization.class);
        example.createCriteria().
                andEqualTo("id", organization.getId()).
                andEqualTo("version", organization.getVersion());
        return this.myDao.update(organization, example);
    }

    @Override
    public List<BaseTreeVO> queryTree() {
        return BeanUtil.convertListToList(this.myDao.queryAll(), BaseTreeVO.class);
    }


    @Override
    public String getOrgName(Long id) {
        return orgDao.getOrgName(id);
    }


    @Override
    public Boolean validateCode(String code) {
        Example example=new Example(Organization.class);
        example.createCriteria().andEqualTo("code",code);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public Boolean validateName(String name) {
        Example example=new Example(Organization.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }
}
