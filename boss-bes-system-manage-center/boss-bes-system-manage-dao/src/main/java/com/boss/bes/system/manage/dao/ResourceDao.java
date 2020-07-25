package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.entity.Resource;

import java.util.List;

/**
 * @description:资源类的Dao层
 * @author:zyz
 * @time:2020/7/10-14:37
 */
public interface ResourceDao {

    Resource query(Long id, Long version);

    List<Resource> queryAllWithPageAndParent(String name, Long parentId);
}
