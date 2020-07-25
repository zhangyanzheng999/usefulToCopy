package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import com.boss.bes.system.manage.pojo.query.UserTreeQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.UserTreeVO;
import com.boss.bes.system.manage.pojo.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:用户的业务层
 * @author:zyz
 * @time:2020/7/12-16:03
 */
public interface UserService {
    /**
     * 分页查找
     *
     * @param pageQuery
     * @return
     */
    PageInfo<UserVO> queryAllWithPageAndCompany(UserPageQuery pageQuery);

    /**
     * 查询用户的树
     *
     * @return
     */
    List<UserTreeVO> queryTree(UserTreeQuery treeQuery);

    /**
     * 根据用户code拿到用户Id
     *
     * @param code
     * @return
     */
    Long getUserIdWithCode(String code);

    /**
     * 考试服务要的接口
     *
     * @param id
     * @return
     */
    UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id);

    /**
     * 生成工号
     *
     * @return
     */
    Long generatorCode();

    List<UserTreeVO> queryUserRoleTree(Long companyId);


    List<Long> getUserIdsWithName(String name);

    List<UserInfoDTO> queryUserByRole(String roleName);

    /**
     * 用来导出
     * @param query
     * @return
     */
    List<UserVO> queryAllUserForExport(BaseTreeQuery query);
}
