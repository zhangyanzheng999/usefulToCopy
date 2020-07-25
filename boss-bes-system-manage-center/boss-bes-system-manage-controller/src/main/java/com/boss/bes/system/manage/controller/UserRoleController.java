package com.boss.bes.system.manage.controller;


import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.pojo.dto.UserRoleDTO;
import com.boss.bes.system.manage.pojo.query.UserRoleQuery;
import com.boss.bes.system.manage.pojo.vo.UserRoleVO;
import com.boss.bes.system.manage.service.UserRoleService;
import com.boss.bes.system.manage.util.BuildResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/16-20:05
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/userRole")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;


    @PostMapping("/getUsersForRole")
    public CommonResponse<UserRoleVO> getUsersForRole(@RequestBody CommonRequest<UserRoleQuery> commonRequest) {

        return BuildResponse.build("200", userRoleService.getUsersForRole(commonRequest.getBody()));
    }

    @PostMapping("/updateUserForRole")
    public CommonResponse<String> updateUserForRole(@RequestBody CommonRequest<UserRoleDTO> commonRequest){
        userRoleService.updateUserForRole(commonRequest.getBody());
        return BuildResponse.build("200","更新成功");
    }

}
