package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.entity.ResourceRole;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;

/**
 * @description:资源角色的dao层
 * @author:zyz
 * @time:2020/7/16-16:33
 */
public interface ResourceRoleDao extends IBaseDao<ResourceRole> {
    ResourceRoleVO queryResourceForRole(Long roleId);
}
