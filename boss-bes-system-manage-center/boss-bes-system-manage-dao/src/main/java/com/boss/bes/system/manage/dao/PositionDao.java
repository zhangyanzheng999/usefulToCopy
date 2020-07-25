package com.boss.bes.system.manage.dao;

import com.boss.bes.system.manage.pojo.entity.Position;

import java.util.List;

/**
 * @description:职位的dao
 * @author:zyz
 * @time:2020/7/12-10:21
 */
public interface PositionDao {
    List<Position> queryAllWithPageAndCompany(String name,Long companyId,Boolean status,Long organizationId);

    Position query(Long id, Long version);
}
