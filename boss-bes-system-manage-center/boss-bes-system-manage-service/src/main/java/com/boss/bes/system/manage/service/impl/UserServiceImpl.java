package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.ServiceException;
import cn.hutool.crypto.SecureUtil;
import com.boss.bes.system.manage.dao.UserDao;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.dto.UserDTO;
import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import com.boss.bes.system.manage.pojo.query.UserTreeQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.UserTreeVO;
import com.boss.bes.system.manage.pojo.vo.UserVO;
import com.boss.bes.system.manage.service.*;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:用户业务类的实现类
 * @author:zyz
 * @time:2020/7/12-16:03
 */
@Service
public class UserServiceImpl extends BaseCRUDService<User, UserDTO, UserVO, UserPageQuery, UserMapper> implements UserService {
    @Autowired
    UserDao userDao;
    /**
     * 用来用户角色操作
     */
    @Autowired
    UserRoleService userRoleService;
    /**
     * 查询资源树
     */
    @Autowired
    CompanyService companyService;

    @Autowired
    DepartmentService departmentService;

    @Override
    public Integer update(UserDTO dto) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        //开始调用修改用户角色表的方法
        userRoleService.updateUserRole(true, dto.getRoles(), dto.getId());
        //假设密码超过20位就已经加密过了
        if (dto.getPassword() != null && dto.getPassword().length() <= 20) {
            //MD5加密
            dto.setPassword(SecureUtil.md5(dto.getPassword()));
        }
        return this.myDao.update(BeanUtil.copyData(dto, User.class), example);
    }

    /**
     * 新增
     *
     * @param dto
     * @return
     */
    @Override
    public Integer save(UserDTO dto) {
        try {
            //MD5加密
            dto.setPassword(SecureUtil.md5(dto.getPassword()));
            Long userId = myDao.saveReturnId(BeanUtil.copyData(dto, User.class));
            //开始调用修改用户角色表的方法
            userRoleService.updateUserRole(false, dto.getRoles(), userId);
            return userId == null ? 0 : 1;
        } catch (Exception ex) {
            throw new ServiceException(BaseCodeEnum.BASE_DATA_INSERT_EXCEPTION, ex);
        }
    }


    @Override
    public PageInfo<UserVO> queryAllWithPageAndCompany(UserPageQuery pageQuery) {
        PageMethod.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        List<User> users = userDao.queryAllWithPageAndCompany(pageQuery);
        PageInfo<User> pageInfo = new PageInfo<>(users, 5);
        return BeanUtil.convertPageInfo(pageInfo, UserVO.class);
    }

    @Override
    public UserVO query(BaseQuery query) {
        User user = userDao.query(query.getId(), query.getVersion());

        return BeanUtil.copyData(user, UserVO.class);
    }


    @Override
    public Long getUserIdWithCode(String code) {
        return userDao.getUserIdWithCode(code);
    }

    @Override
    public UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id) {
        return userDao.getUserWithOrgIdAndCompanyIdAndName(id);
    }

    @Override
    public Long generatorCode() {
        return userDao.generatorCode();
    }

    /**
     * 查询树
     *
     * @param treeQuery
     * @return
     */
    @Override
    public List<UserTreeVO> queryTree(UserTreeQuery treeQuery) {
        //首先看有没有组织Id
        // 可能有组织但没公司这样是组织管理员
        // 有公司一定有组织，这样是公司管理员
        List<UserTreeVO> userTreeVOS = new ArrayList<>();
        if (treeQuery.getCompanyId() == null) {
            userTreeVOS = BeanUtil.convertListToList(companyService.queryCompanyByOrgId(treeQuery.getOrganizationId()), UserTreeVO.class);
            for (UserTreeVO userTreeVO : userTreeVOS) {
                userTreeVO.setChildren(BeanUtil.convertListToList(departmentService.queryDepartmentByCompanyId(userTreeVO.getId()), UserTreeVO.class));
            }
        } else {
            UserTreeVO userTreeVO = BeanUtil.copyData(companyService.getCompanyById(treeQuery.getCompanyId()), UserTreeVO.class);
            userTreeVO.setChildren(BeanUtil.convertListToList(departmentService.queryDepartmentByCompanyId(treeQuery.getCompanyId()), UserTreeVO.class));
            userTreeVOS.add(userTreeVO);
        }
        return userTreeVOS;
    }

    /**
     * 查询用户角色树
     *
     * @param companyId
     * @return
     */
    @Override
    public List<UserTreeVO> queryUserRoleTree(Long companyId) {
        List<UserTreeVO> userTreeVOS = BeanUtil.convertListToList(departmentService.queryDepartmentByCompanyId(companyId), UserTreeVO.class);
        Example example;
        for (UserTreeVO userTreeVO : userTreeVOS) {
            example = new Example(User.class);
            example.createCriteria().andEqualTo("departmentId", userTreeVO.getId());
            //防止部门id与用户Id冲突
            userTreeVO.setId(-userTreeVO.getId());
            userTreeVO.setChildren(BeanUtil.convertListToList(this.myDao.getListByExample(example), UserTreeVO.class));
        }
        return userTreeVOS;
    }

    /**
     * 根据名字拿Id的List
     *
     * @param name
     * @return
     */
    @Override
    public List<Long> getUserIdsWithName(String name) {
        Example example = new Example(User.class);
        example.selectProperties("id").createCriteria().andEqualTo("name", name);
        List<User> userList = this.myDao.getListByExample(example);

        return userList.stream().map(User::getId).collect(Collectors.toList());
    }


    /**
     * 这个验证Code是否使用过
     *
     * @param code
     * @return
     */
    @Override
    public Boolean validateCode(String code) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("code", code);
        return myDao.getListByExample(example).isEmpty();
    }

    /**
     * 这个验证名字是否使用过
     *
     * @param name
     * @return
     */
    @Override
    public Boolean validateName(String name) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name", name);
        return myDao.getListByExample(example).isEmpty();
    }


    /**
     * 通过角色名字拿用户信息
     */
    @Override
    public List<UserInfoDTO> queryUserByRole(String roleName) {
        return userDao.queryUserByRole(roleName);
    }

    /**
     * 用来查询用户去导出，但是注意不能全部导出，只能是该公司或者该组织旗下的
     *
     * @param query
     * @return
     */
    @Override
    public List<UserVO> queryAllUserForExport(BaseTreeQuery query) {
        UserPageQuery userPageQuery = BeanUtil.copyData(query, UserPageQuery.class);
        return BeanUtil.convertListToList(userDao.queryAllWithPageAndCompany(userPageQuery), UserVO.class);
    }
}
