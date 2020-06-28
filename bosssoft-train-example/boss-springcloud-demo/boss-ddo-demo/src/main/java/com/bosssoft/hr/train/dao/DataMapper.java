package com.bosssoft.hr.train.dao;

import com.bosssoft.hr.train.bean.DataDictionary;

import java.util.List;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-21:01
 */
public interface DataMapper {
    List<DataDictionary> queryDds();

    DataDictionary findById(Integer id);

    Integer deleteById(Integer id);

    Integer updateDD(DataDictionary dataDictionary);

    Integer insertDD(DataDictionary dataDictionary);
}
