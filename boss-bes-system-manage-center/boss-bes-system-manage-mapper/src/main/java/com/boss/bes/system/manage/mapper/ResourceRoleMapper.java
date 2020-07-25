package com.boss.bes.system.manage.mapper;


import com.boss.bes.system.manage.pojo.entity.ResourceRole;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;

public interface ResourceRoleMapper extends CommonMapper<ResourceRole> {
    ResourceRoleVO queryResourceForRole(Long roleId);
}