package com.boss.bes.system.manage.service;

import com.boss.bes.system.manage.pojo.dto.ResourceRoleDTO;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;

/**
 * @description:资源角色业务层接口
 * @author:zyz
 * @time:2020/7/16-16:31
 */
public interface ResourceRoleService {
    ResourceRoleVO queryResourceForRole(Long roleId);

    void updateResourceForRole(ResourceRoleDTO dto);
}
