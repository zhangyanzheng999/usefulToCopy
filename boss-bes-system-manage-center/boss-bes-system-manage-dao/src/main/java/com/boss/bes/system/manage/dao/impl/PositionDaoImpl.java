package com.boss.bes.system.manage.dao.impl;

import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.DaoException;
import com.boss.bes.system.manage.mapper.PositionMapper;
import com.boss.bes.system.manage.pojo.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:职位dao的实现类
 * @author:zyz
 * @time:2020/7/12-10:24
 */
@Repository
public class PositionDaoImpl extends AbstractPositionDao {
    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<Position> queryAllWithPageAndCompany(String name, Long companyId, Boolean status,Long organizationId) {
        try {
            return positionMapper.getPositionWithPage(name, companyId, status,organizationId);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }

    @Override
    public Position query(Long id, Long version) {
        try {
            return positionMapper.getPosition(id, version);
        } catch (Exception e) {
            throw new DaoException(BaseCodeEnum.BASE_DATA_SELECT_EXCEPTION, e);
        }
    }
}
