package com.boss.bes.system.manage.api;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.common.CommonCRUDApi;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.dto.UserDTO;
import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import com.boss.bes.system.manage.pojo.query.UserTreeQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.UserTreeVO;
import com.boss.bes.system.manage.pojo.vo.UserVO;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description:用户服务api
 * @author:zyz
 * @time:2020/7/12-15:55
 */
public interface UserServiceApi extends CommonCRUDApi<User, UserDTO, UserVO, UserPageQuery, UserMapper> {

    @ApiOperation("输入用户ID获得该用户的公司ID、组织ID和姓名")
    UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(Long id);

    @ApiOperation("输入用户Code获得该用户的ID")
    Long getUserIdWithCode(String code);

    @ApiOperation("输入用户名字拿到对应的Id，由于可能重名返回一个List")
    List<Long> getUserIdsWithName(String name);


    @ApiOperation("查询用户用来导出，查询条件组织+公司")
    CommonResponse<List<UserVO>> queryAllUserForExport(CommonRequest<BaseTreeQuery> commonRequest);

    CommonResponse<String> multiInsert(CommonRequest<UserDTO> commonRequest);

    @ApiOperation("生成用户工号")
    CommonResponse<Long> generatorCode();

    @ApiOperation("查询公司+部门树")
    CommonResponse<List<UserTreeVO>> queryTree(CommonRequest<UserTreeQuery> commonRequest);

    @ApiOperation("查询部门+用户树 通过公司Id")
    CommonResponse<List<UserTreeVO>> queryUserRoleTree(CommonRequest<Long> commonRequest);

    @ApiOperation("服务之间传入角色名拿到对应的用户信息")
    List<UserInfoDTO> queryUserByRole(String roleName);
}
