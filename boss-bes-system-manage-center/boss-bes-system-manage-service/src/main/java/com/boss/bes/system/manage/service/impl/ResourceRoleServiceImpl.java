package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.BusinessException;
import com.boss.bes.system.manage.dao.ResourceRoleDao;
import com.boss.bes.system.manage.pojo.dto.ResourceRoleDTO;
import com.boss.bes.system.manage.pojo.entity.ResourceRole;
import com.boss.bes.system.manage.pojo.vo.ResourceRoleVO;
import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.boss.bes.system.manage.service.ResourceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;

/**
 * @description: 资源角色的业务层实现类
 * @author:zyz
 * @time:2020/7/16-16:32
 */
@Service
public class ResourceRoleServiceImpl implements ResourceRoleService {
    @Autowired
    ResourceRoleDao resourceRoleDao;

    @Override
    public ResourceRoleVO queryResourceForRole(Long roleId) {
        ResourceRoleVO resourceRoleVO = resourceRoleDao.queryResourceForRole(roleId);
        // 如果结果为null，那么构造一个空的返回
        return resourceRoleVO == null ? new ResourceRoleVO(null, roleId, new ArrayList<>()) : resourceRoleVO;
    }

    /**
     * 开启事务
     * 防止中间出错，出错需要回滚
     *
     * @param dto
     */
    @Override
    @Transactional
    public void updateResourceForRole(ResourceRoleDTO dto) {
        //首先删除角色资源中间表中的该角色对应的信息
        Example example = new Example(ResourceRole.class);
        example.createCriteria().andEqualTo("roleId", dto.getRoleId());
        //这个是为了删除时有一个标准
        int result = resourceRoleDao.getListByExample(example).size();
        // 如果结果数不对，抛出异常回滚
        if (resourceRoleDao.delete(example) != result) {
            throw new BusinessException(SystemManageCodeEnum.SYSTEM_MANAGE_ROLE_RESOURCE_UPDATE_EXCEPTION);
        }
        //删除之后，重新添加，进行递归(注意孩子结点)
        for (ResourceTreeVO resource : dto.getResources()) {
            saveResource(dto.getRoleId(), resource);
        }
    }

    /**
     * 递归添加资源
     *
     * @param roleId 这个是角色Id，是固定的
     * @param treeVO 这个是需要添加的资源结点
     */
    public void saveResource(Long roleId, ResourceTreeVO treeVO) {
        //如果结点为null，结束递归
        if (treeVO == null) {
            return;
        }
        //创建资源角色类
        ResourceRole resourceRole = new ResourceRole(roleId, treeVO.getId());
        // 保存失败抛出异常
        if (resourceRoleDao.save(resourceRole) == 0) {
            throw new BusinessException(SystemManageCodeEnum.SYSTEM_MANAGE_ROLE_RESOURCE_UPDATE_EXCEPTION);
        }
        // 如果没有孩子结点那么结束递归
        if (treeVO.getChildren() == null || treeVO.getChildren().isEmpty()) return;
        // 继续添加孩子结点
        for (ResourceTreeVO child : treeVO.getChildren()) {
            saveResource(roleId, child);
        }
    }


}
