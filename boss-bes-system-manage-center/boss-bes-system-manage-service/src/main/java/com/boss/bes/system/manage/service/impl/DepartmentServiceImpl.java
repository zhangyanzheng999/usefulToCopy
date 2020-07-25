package com.boss.bes.system.manage.service.impl;

import com.boss.bes.system.manage.dao.DepartmentDao;
import com.boss.bes.system.manage.mapper.DepartmentMapper;
import com.boss.bes.system.manage.pojo.dto.DepartmentDTO;
import com.boss.bes.system.manage.pojo.entity.Department;
import com.boss.bes.system.manage.pojo.query.DepartmentPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.DepartmentTreeVO;
import com.boss.bes.system.manage.pojo.vo.DepartmentVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.CompanyService;
import com.boss.bes.system.manage.service.DepartmentService;
import com.boss.bes.system.manage.service.OrgService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.ArrayList;
import java.util.List;


/**
 * @description:部门业务实现类
 * @author:zyz
 * @time:2020/7/9-14:42
 */
@Service
public class DepartmentServiceImpl extends BaseCRUDService<Department, DepartmentDTO, DepartmentVO, DepartmentPageQuery, DepartmentMapper> implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    /**
     * 这两个用来构造资源树
     */
    @Autowired
    OrgService orgService;

    @Autowired
    CompanyService companyService;

    @Override
    public PageInfo<DepartmentVO> queryAllWithPageAndCompany(DepartmentPageQuery departmentPageQuery) {
        PageMethod.startPage(departmentPageQuery.getPageNum(), departmentPageQuery.getPageSize());
        List<Department> departments = departmentDao.queryAllWithPageAndCompany("%" + departmentPageQuery.getName() + "%",
                departmentPageQuery.getCompanyId(),
                departmentPageQuery.getOrganizationId(),
                departmentPageQuery.getParentId());
        PageInfo<Department> pageInfo = new PageInfo<>(departments, 5);
        return BeanUtil.convertPageInfo(pageInfo, DepartmentVO.class);
    }


    @Override
    public DepartmentVO query(BaseQuery query) {
        Department department = departmentDao.query(query.getId(), query.getVersion());
        return BeanUtil.copyData(department, DepartmentVO.class);
    }


    @Override
    public List<DepartmentVO> queryDepartmentByCompanyId(Long companyId, Long departmentId) {
        Example example = new Example(Department.class);
        example.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("id", departmentId);
        List<Department> departments = this.myDao.getListByExample(example);
        return BeanUtil.convertListToList(departments, DepartmentVO.class);
    }


    @Override
    public List<DepartmentVO> queryDepartmentByCompanyId(Long companyId) {
        Example example = new Example(Department.class);
        example.createCriteria().andEqualTo("companyId", companyId);
        List<Department> departments = this.myDao.getListByExample(example);
        return BeanUtil.convertListToList(departments, DepartmentVO.class);
    }

    @Override
    public Integer update(DepartmentDTO dto) {
        Example example = new Example(Department.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        return this.myDao.update(BeanUtil.copyData(dto, Department.class), example);
    }

    @Override
    public List<DepartmentTreeVO> queryTree(BaseTreeQuery query) {
        List<DepartmentTreeVO> departmentTreeVOS = new ArrayList<>();
        //组织或者公司管理员
        if (query.getCompanyId() == null) {
            departmentTreeVOS = BeanUtil.convertListToList(orgService.queryAll(query.getOrganizationId()), DepartmentTreeVO.class);
        } else {
            departmentTreeVOS.add(BeanUtil.copyData(companyService.getCompanyById(query.getCompanyId()), DepartmentTreeVO.class));
        }
        //去循环构造树
        for (DepartmentTreeVO departmentTreeVO : departmentTreeVOS) {
            buildTree(departmentTreeVO);
        }

        return departmentTreeVOS;
    }


    /**
     * 构建部门
     *
     * @param departmentTreeVO
     */
    public void buildTree(DepartmentTreeVO departmentTreeVO) {
        if (departmentTreeVO == null) return;
        //将组织加进来
        if (departmentTreeVO.getOrganizationId() == null && departmentTreeVO.getCompanyId() == null) {
            departmentTreeVO.setChildren(BeanUtil.convertListToList(companyService.queryCompanyByOrgId(departmentTreeVO.getId()), DepartmentTreeVO.class));
        } else {
            Example example = new Example(Department.class);
            //继续构建，这次处理第一级部门
            if (departmentTreeVO.getCompanyId() == null) {
                example.createCriteria().
                        andIsNull("parentId").
                        andEqualTo("companyId", departmentTreeVO.getId());
            } else {
                //处理部门关系,排除自身防止憨批乱改数据库出问题
                example.createCriteria().
                        andEqualTo("parentId", departmentTreeVO.getId()).
                        andNotEqualTo("id", departmentTreeVO.getId());
            }
            departmentTreeVO.setChildren(BeanUtil.convertListToList(this.myDao.getListByExample(example), DepartmentTreeVO.class));
        }
        //终止条件
        if (departmentTreeVO.getChildren() == null || departmentTreeVO.getChildren().isEmpty()) return;
        for (DepartmentTreeVO child : departmentTreeVO.getChildren()) {
            buildTree(child);
        }
    }



    @Override
    public Boolean validateCode(String code) {
        Example example=new Example(Department.class);
        example.createCriteria().andEqualTo("code",code);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public Boolean validateName(String name) {
        Example example=new Example(Department.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }
}
