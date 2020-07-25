package com.boss.bes.system.manage.controller;

import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.pojo.dto.ResourceRoleDTO;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;
import com.boss.bes.system.manage.service.ResourceRoleService;
import com.boss.bes.system.manage.util.BuildResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:资源角色的控制器
 * @author:zyz
 * @time:2020/7/17-11:39
 */
@RestController
@RequestMapping("/education/bes/v1/system-manager-center/resourceRole")
public class ResourceRoleController {
    @Autowired
    ResourceRoleService resourceRoleService;


    @GetMapping("/queryResourceForRole")
    public CommonResponse<ResourceRoleVO> queryResourceForRole(@RequestParam("roleId") Long roleId){
        return BuildResponse.build("200",resourceRoleService.queryResourceForRole(roleId));
    }
    @PostMapping("/updateResourceForRole")
    public CommonResponse<String> updateResourceForRole(@RequestBody CommonRequest<ResourceRoleDTO> commonRequest){
        resourceRoleService.updateResourceForRole(commonRequest.getBody());
        return BuildResponse.build("200","资源更新成功");
    }
}
