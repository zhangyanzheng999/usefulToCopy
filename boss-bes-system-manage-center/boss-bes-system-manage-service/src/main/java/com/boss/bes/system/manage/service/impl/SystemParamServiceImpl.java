package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.BusinessException;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.bes.system.manage.constant.SystemManagerConstraint;
import com.boss.bes.system.manage.dao.SystemParamDao;
import com.boss.bes.system.manage.mapper.SystemParamMapper;
import com.boss.bes.system.manage.pojo.dto.SystemParamDTO;
import com.boss.bes.system.manage.pojo.dto.SystemParamImportDTO;
import com.boss.bes.system.manage.pojo.entity.Dictionary;
import com.boss.bes.system.manage.pojo.entity.SystemParam;
import com.boss.bes.system.manage.pojo.query.SystemParamPageQuery;
import com.boss.bes.system.manage.pojo.vo.SystemParamTreeVO;
import com.boss.bes.system.manage.pojo.vo.SystemParamVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.DictionaryService;
import com.boss.bes.system.manage.service.SystemParamService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/12-16:05
 */
@Service
public class SystemParamServiceImpl extends BaseCRUDService<SystemParam, SystemParamDTO, SystemParamVO, SystemParamPageQuery, SystemParamMapper> implements SystemParamService {
    @Autowired
    SystemParamDao systemParamDao;

    @Autowired
    DictionaryService dictionaryService;

    @Override
    public Integer update(SystemParamDTO dto) {
        Example example = new Example(SystemParam.class);
        example.createCriteria().andEqualTo("id", dto.getId()).andEqualTo("version", dto.getVersion());
        return this.myDao.update(BeanUtil.copyData(dto, SystemParam.class), example);
    }

    /**
     * 开启事务
     *
     * @param systemParamDTOList
     * @return
     */
    @Override
    @Transactional
    public Integer multiInsert(List<SystemParamImportDTO> systemParamDTOList) {
        Snowflake snowflake = IdUtil.getSnowflake(SystemManagerConstraint.WORKER_ID, SystemManagerConstraint.DATA_CENTER_ID);
        for (SystemParamImportDTO systemParamDTO : systemParamDTOList) {
            SystemParam systemParam = BeanUtil.copyData(systemParamDTO, SystemParam.class);
            systemParam.setId(snowflake.nextId());
            if (this.myDao.save(systemParam) == 0) {
                throw new BusinessException(SystemManageCodeEnum.SYSTEM_MANAGE_DATA_IMPORT_EXCEPTION);
            }
        }
        return systemParamDTOList.size();
    }

    /**
     * 系统参数的分页查询
     *
     * @param pageQuery
     * @return
     */
    @Override
    public PageInfo<SystemParamVO> queryWithPage(SystemParamPageQuery pageQuery) {
        PageMethod.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        Example example = new Example(SystemParam.class);
        example.orderBy("createdTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + pageQuery.getName() + "%");
        if (pageQuery.getParamType() != null) {
            criteria.andEqualTo("paramType", pageQuery.getParamType());
        }
        List<SystemParam> params = this.myDao.getListByExample(example);
        PageInfo<SystemParam> pageInfo = new PageInfo<>(params, 5);
        return BeanUtil.convertPageInfo(pageInfo, SystemParamVO.class);
    }

    /**
     * 查询参数树：类型+参数
     *
     * @return
     */
    @Override
    public List<SystemParamTreeVO> queryTree() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaryForType("系统参数");
        List<SystemParamTreeVO> systemParamTreeVOS = BeanUtil.convertListToList(dictionaries, SystemParamTreeVO.class);
        Example example = null;
        for (SystemParamTreeVO systemParamTreeVO : systemParamTreeVOS) {
            example = new Example(SystemParam.class);
            example.createCriteria().andEqualTo("paramType", systemParamTreeVO.getName());
            List<SystemParam> params = this.myDao.getListByExample(example);
            systemParamTreeVO.setChildren(params);
        }

        return systemParamTreeVOS;
    }

    @Override
    public List<SystemParamVO> getAllSystemParam() {
        return BeanUtil.convertListToList(this.myDao.queryAll(), SystemParamVO.class);
    }




    @Override
    public Boolean validateName(String name) {
        Example example=new Example(SystemParam.class);
        example.createCriteria().andEqualTo("name",name);
        return myDao.getListByExample(example).isEmpty();
    }
}
