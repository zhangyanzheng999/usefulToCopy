package com.boss.bes.system.manage.service.impl;

import com.boss.bes.system.manage.dao.PositionDao;
import com.boss.bes.system.manage.mapper.PositionMapper;
import com.boss.bes.system.manage.pojo.dto.PositionDTO;
import com.boss.bes.system.manage.pojo.entity.Position;
import com.boss.bes.system.manage.pojo.query.PositionPageQuery;
import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.boss.bes.system.manage.pojo.vo.PositionVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.PositionService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:业务层的实现类
 * @author:zyz
 * @time:2020/7/12-10:25
 */
@Service
public class PositionServiceImpl extends BaseCRUDService<Position, PositionDTO, PositionVO, PositionPageQuery, PositionMapper> implements PositionService {

    @Autowired
    PositionDao positionDao;

    @Override
    public PageInfo<PositionVO> queryAllWithPageAndCompany(PositionPageQuery pageQuery) {
        PageMethod.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        List<Position> positions = positionDao.queryAllWithPageAndCompany("%" + pageQuery.getName() + "%",
                pageQuery.getCompanyId(),
                pageQuery.getStatus(),
                pageQuery.getOrganizationId());
        PageInfo<Position> pageInfo = new PageInfo<>(positions, 5);
        return BeanUtil.convertPageInfo(pageInfo, PositionVO.class);
    }


    @Override
    public Integer update(PositionDTO dto) {
        Example example = new Example(Position.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        return myDao.update(BeanUtil.copyData(dto, Position.class), example);
    }

    @Override
    public PositionVO query(BaseQuery query) {
        Position position = positionDao.query(query.getId(), query.getVersion());
        return BeanUtil.copyData(position, PositionVO.class);
    }


    @Override
    public List<PositionVO> queryPositionByCompanyId(Long companyId) {
        Example example = new Example(Position.class);
        example.createCriteria().andEqualTo("companyId", companyId);
        return BeanUtil.convertListToList(myDao.getListByExample(example), PositionVO.class);
    }


    @Override
    public Boolean validateCode(String code) {
        Example example=new Example(Position.class);
        example.createCriteria().andEqualTo("code",code);
        return myDao.getListByExample(example).isEmpty();
    }


    @Override
    public Boolean validateName(String name) {
        Example example=new Example(Position.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }
}
