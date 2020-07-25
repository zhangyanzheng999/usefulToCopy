package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.api.UserServiceApi;
import com.boss.bes.system.manage.controller.common.BaseCRUDController;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.dto.UserDTO;
import com.boss.bes.system.manage.pojo.dto.UserForExamDTO;
import com.boss.bes.system.manage.pojo.dto.UserInfoDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserPageQuery;
import com.boss.bes.system.manage.pojo.query.UserTreeQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseTreeQuery;
import com.boss.bes.system.manage.pojo.vo.UserTreeVO;
import com.boss.bes.system.manage.pojo.vo.UserVO;
import com.boss.bes.system.manage.service.UserService;
import com.boss.bes.system.manage.util.BuildResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:用户控制器
 * @author:zyz
 * @time:2020/7/12-15:55
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/user")
public class UserController extends BaseCRUDController<User, UserDTO, UserVO, UserPageQuery, UserMapper> implements UserServiceApi {
    @Autowired
    UserService userService;


    @Override
    @PostMapping("/multiDelete")
    public CommonResponse<String> multiDelete(@RequestBody CommonRequest<List<UserDTO>> commonRequest) {
        return super.multiDelete(commonRequest, User.class);
    }


    @Override
    @PostMapping("/insert")
    public CommonResponse<String> insert(@RequestBody CommonRequest<UserDTO> commonRequest) {
        return super.insert(commonRequest);
    }

    @Override
    @PostMapping("/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        return super.delete(commonRequest, User.class);
    }

    @Override
    @PutMapping("/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<UserDTO> commonRequest) {
        return super.update(commonRequest);
    }


    @Override
    @PostMapping("/queryWithPage")
    public CommonResponse<PageInfo<UserVO>> queryWithPage(@RequestBody CommonRequest<UserPageQuery> commonRequest) {
        return BuildResponse.build("200", userService.queryAllWithPageAndCompany(commonRequest.getBody()));
    }


    @Override
    @PostMapping("/query")
    public CommonResponse<UserVO> query(@RequestBody CommonRequest<BaseQuery> commonRequest) {
        return super.query(commonRequest);
    }

    @Override
    @GetMapping("/generatorCode")
    public CommonResponse<Long> generatorCode() {
        return BuildResponse.build("200", userService.generatorCode());
    }

    @Override
    @PostMapping("/queryTree")
    public CommonResponse<List<UserTreeVO>> queryTree(@RequestBody CommonRequest<UserTreeQuery> commonRequest) {
        return BuildResponse.build("200", userService.queryTree(commonRequest.getBody()));
    }


    @Override
    @PostMapping("/queryUserRoleTree")
    public CommonResponse<List<UserTreeVO>> queryUserRoleTree(@RequestBody CommonRequest<Long> commonRequest) {
        return BuildResponse.build("200",userService.queryUserRoleTree(commonRequest.getBody()));
    }

    /**
     * 下面是为考试系统提供的两个方法
     */

    @Override
    @GetMapping("/getUserIdWithCode")
    public Long getUserIdWithCode(@RequestParam("code") String code) {
        return userService.getUserIdWithCode(code);
    }

    @Override
    @GetMapping("/getUserWithOrgIdAndCompanyIdAndName")
    public UserForExamDTO getUserWithOrgIdAndCompanyIdAndName(@RequestParam("id") Long id) {
        return userService.getUserWithOrgIdAndCompanyIdAndName(id);
    }

    @Override
    @GetMapping("/getUserIdsWithName")
    public List<Long> getUserIdsWithName(@RequestParam("name") String name) {
        return userService.getUserIdsWithName(name);
    }


    @Override
    @GetMapping("/validateName")
    public CommonResponse<Boolean> validateName(@RequestParam("name") String name) {
        return super.validateName(name);
    }

    @Override
    @GetMapping("/validateCode")
    public CommonResponse<Boolean> validateCode(@RequestParam("code") String code) {
        return super.validateCode(code);
    }


    @Override
    @GetMapping("/queryUserByRole")
    public List<UserInfoDTO> queryUserByRole(@RequestParam("roleName") String roleName) {
        return userService.queryUserByRole(roleName);
    }


    @Override
    @PostMapping("/queryAllUserForExport")
    public CommonResponse<List<UserVO>> queryAllUserForExport(@RequestBody CommonRequest<BaseTreeQuery> commonRequest) {
        return BuildResponse.build("200",userService.queryAllUserForExport(commonRequest.getBody()));
    }


    @Override
    @PostMapping("/multiInsert")
    public CommonResponse<String> multiInsert(@RequestBody CommonRequest<UserDTO> commonRequest) {
        return null;
    }
}
