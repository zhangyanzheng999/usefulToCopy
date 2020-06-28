package com.bosssoft.hr.train.service;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.github.pagehelper.PageInfo;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-21:27
 */

public interface DDService {
    /**
     * 按照id获取
     * @param id
     * @return
     */
    DataDictionary getDDById(Integer id);

    /**
     * 得到分页信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<DataDictionary> queryDDWithPage(Integer pageNum, Integer pageSize);

    /**
     * 修改
     * @param dataDictionary
     */
    DataDictionary update(DataDictionary dataDictionary);

    /**
     * 按照id删除
     * @param id
     */
    Integer deleteById(Integer id);

    /**
     * 插入
     * @param dataDictionary
     */
    DataDictionary insert(DataDictionary dataDictionary);
}
