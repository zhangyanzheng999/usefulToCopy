package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.dao.DictionaryDao;
import com.boss.bes.system.manage.mapper.DictionaryMapper;
import com.boss.bes.system.manage.pojo.entity.Dictionary;

/**
 * @description:数据字典的抽象类
 * @author:zyz
 * @time:2020/7/14-16:58
 */
public abstract class AbstractDictionaryDao extends AbstractBaseDao<Dictionary, DictionaryMapper> implements DictionaryDao {
}
