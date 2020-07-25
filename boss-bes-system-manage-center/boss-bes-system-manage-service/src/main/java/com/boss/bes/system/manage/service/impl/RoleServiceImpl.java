package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.ServiceException;
import com.boss.bes.system.manage.dao.RoleDao;
import com.boss.bes.system.manage.mapper.RoleMapper;
import com.boss.bes.system.manage.pojo.dto.RoleDTO;
import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.query.RolePageQuery;
import com.boss.bes.system.manage.pojo.query.RoleQuery;
import com.boss.bes.system.manage.pojo.query.RoleTreeQuery;
import com.boss.bes.system.manage.pojo.vo.RoleVO;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.CompanyRoleService;
import com.boss.bes.system.manage.service.CompanyService;
import com.boss.bes.system.manage.service.RoleService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:角色业务层实现类
 * @author:zyz
 * @time:2020/7/11-19:57
 */
@Service
public class RoleServiceImpl extends BaseCRUDService<Role, RoleDTO, RoleVO, RolePageQuery, RoleMapper> implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    CompanyRoleService companyRoleService;

    @Autowired
    CompanyService companyService;

    @Override
    public PageInfo<RoleVO> queryAllWithPageAndCompanyAndOrg(RolePageQuery rolePageQuery) {
        PageMethod.startPage(rolePageQuery.getPageNum(), rolePageQuery.getPageSize());
        List<Role> roles = roleDao.queryAllWithPageAndCompanyAndOrg("%" + rolePageQuery.getName() + "%", rolePageQuery.getCompanyId(), rolePageQuery.getOrganizationId());
        PageInfo<Role> pageInfo = new PageInfo<>(roles, 5);
        return BeanUtil.convertPageInfo(pageInfo, RoleVO.class);
    }


    @Override
    public List<RoleVO> queryRoleByByCompanyId(Long companyId) {
        return BeanUtil.convertListToList(roleDao.getRoleWithCompanyId(companyId), RoleVO.class);
    }


    @Override
    public RoleVO queryForRole(RoleQuery query) {
        if (query.getCompanyId() == null) {
            return BeanUtil.copyData(roleDao.query(query.getId(), query.getVersion()), RoleVO.class);
        } else {
            return BeanUtil.copyData(roleDao.queryWithCompanyId(query.getId(), query.getVersion(), query.getCompanyId()), RoleVO.class);
        }
    }


    @Override
    public Integer save(RoleDTO dto) {
        try {
            Example example = new Example(Role.class);
            example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
            Long roleId = myDao.saveReturnId(BeanUtil.copyData(dto, Role.class));
            companyRoleService.updateCompanyRole(false, dto.getCompanyList(), roleId);
            return roleId == null ? 0 : 1;
        } catch (Exception e) {
            throw new ServiceException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION, e);
        }
    }

    @Override
    public Integer update(RoleDTO dto) {
        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        companyRoleService.updateCompanyRole(true, dto.getCompanyList(), dto.getId());
        return this.myDao.update(BeanUtil.copyData(dto, Role.class), example);
    }


    @Override
    public List<BaseTreeVO> queryCompanyForTree(RoleTreeQuery query) {
        List<BaseTreeVO> baseTreeVOS = new ArrayList<>();
        if (query.getCompanyId() == null) {
            baseTreeVOS = BeanUtil.convertListToList(companyService.queryCompanyByOrgId(query.getOrganizationId()), BaseTreeVO.class);
        } else {
            baseTreeVOS.add(BeanUtil.copyData(companyService.getCompanyById(query.getCompanyId()), BaseTreeVO.class));
        }
        return baseTreeVOS;
    }


    @Override
    public Long generatorCode() {
        return roleDao.generatorCode();
    }

    @Override
    public Boolean validateCode(String code) {
        Example example=new Example(Role.class);
        example.createCriteria().andEqualTo("code",code);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public Boolean validateName(String name) {
        Example example=new Example(Role.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }
}
