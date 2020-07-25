package com.boss.bes.system.manage.service.impl;

import boss.bes.log.exception.code.enums.SystemManageCodeEnum;
import boss.bes.log.exception.type.BusinessException;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.boss.bes.system.manage.constant.SystemManagerConstraint;
import com.boss.bes.system.manage.dao.DictionaryDao;
import com.boss.bes.system.manage.mapper.DictionaryMapper;
import com.boss.bes.system.manage.pojo.dto.DictionaryDTO;
import com.boss.bes.system.manage.pojo.entity.Dictionary;
import com.boss.bes.system.manage.pojo.query.DictionaryPageQuery;
import com.boss.bes.system.manage.pojo.vo.DictionaryVO;
import com.boss.bes.system.manage.service.BaseCRUDService;
import com.boss.bes.system.manage.service.DictionaryService;
import com.boss.bes.system.manage.util.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:数据字典的业务实现类
 * @author:zyz
 * @time:2020/7/14-16:59
 */
@Service
public class DictionaryServiceImpl extends BaseCRUDService<Dictionary, DictionaryDTO, DictionaryVO, DictionaryPageQuery, DictionaryMapper> implements DictionaryService {
    @Autowired
    DictionaryDao dictionaryDao;


    @Override
    public PageInfo<DictionaryVO> queryAllWithPageGroupByOrg(DictionaryPageQuery pageQuery) {
        PageMethod.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        Example example = new Example(Dictionary.class);
        example.orderBy("createdTime").desc();
        example.createCriteria().andEqualTo("organizationId", pageQuery.getOrganizationId())
                .andLike("name", "%" + pageQuery.getName() + "%")
                .andLike("category", "%" + pageQuery.getCategory() + "%");
        List<Dictionary> dictionaries = this.myDao.getListByExample(example);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(dictionaries, 5);
        return BeanUtil.convertPageInfo(pageInfo, DictionaryVO.class);
    }


    @Override
    public Integer update(DictionaryDTO dictionaryDTO) {
        Dictionary dictionary = BeanUtil.copyData(dictionaryDTO, Dictionary.class);
        Example example = new Example(Dictionary.class);
        example.createCriteria().
                andEqualTo("id", dictionaryDTO.getId()).
                andEqualTo("version", dictionaryDTO.getVersion());
        return this.myDao.update(dictionary, example);
    }


    @Override
    @Transactional
    public Integer multiInsert(List<DictionaryDTO> dictionaryDTOList) {
        Snowflake snowflake = IdUtil.getSnowflake(SystemManagerConstraint.WORKER_ID, SystemManagerConstraint.DATA_CENTER_ID);
        for (DictionaryDTO dictionaryDTO : dictionaryDTOList) {
            Dictionary dictionary = BeanUtil.copyData(dictionaryDTO, Dictionary.class);
            dictionary.setId(snowflake.nextId());
            if (this.myDao.save(dictionary) == 0) {
                throw new BusinessException(SystemManageCodeEnum.SYSTEM_MANAGE_DATA_IMPORT_EXCEPTION);
            }
        }
        return dictionaryDTOList.size();
    }

    /**
     * 通过类别名字拿到字典
     *
     * @param category
     * @return
     */
    @Override
    public List<Dictionary> getDictionaryForType(String category) {
        Example example = new Example(Dictionary.class);
        example.createCriteria().andEqualTo("category", category);
        return this.myDao.getListByExample(example);
    }


    @Override
    public List<DictionaryVO> getAllDictionary(Long orgId) {
        Example example = new Example(Dictionary.class);
        example.createCriteria().andEqualTo("organizationId", orgId);
        return BeanUtil.convertListToList(this.myDao.getListByExample(example), DictionaryVO.class);
    }


    @Override
    public Boolean validateName(String name) {
        Example example = new Example(Dictionary.class);
        example.createCriteria().andEqualTo("name", name);
        return myDao.getListByExample(example).isEmpty();
    }
}
