package com.boss.bes.system.manage.service;


import com.boss.bes.system.manage.pojo.dto.DictionaryDTO;
import com.boss.bes.system.manage.pojo.entity.Dictionary;
import com.boss.bes.system.manage.pojo.query.DictionaryPageQuery;
import com.boss.bes.system.manage.pojo.vo.DictionaryVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:数据字典的服务类
 * @author:zyz
 * @time:2020/7/14-16:59
 */
public interface DictionaryService {
    /**
     * 根据组织Id查询出来
     * @param pageQuery
     * @return
     */
    PageInfo<DictionaryVO> queryAllWithPageGroupByOrg(DictionaryPageQuery pageQuery);

    Integer multiInsert(List<DictionaryDTO> dictionaryDTOList);


    List<Dictionary> getDictionaryForType(String category);

    List<DictionaryVO> getAllDictionary(Long orgId);
}
