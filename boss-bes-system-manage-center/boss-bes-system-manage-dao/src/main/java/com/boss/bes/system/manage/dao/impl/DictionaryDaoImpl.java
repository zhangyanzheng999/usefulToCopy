package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:数据字典的dao层
 * @author:zyz
 * @time:2020/7/14-16:58
 */
@Repository
public class DictionaryDaoImpl extends AbstractDictionaryDao {
    @Autowired
    DictionaryMapper dictionaryMapper;




}
