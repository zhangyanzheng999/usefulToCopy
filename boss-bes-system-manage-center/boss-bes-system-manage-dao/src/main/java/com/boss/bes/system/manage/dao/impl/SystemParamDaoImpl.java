package com.boss.bes.system.manage.dao.impl;

import com.boss.bes.system.manage.mapper.SystemParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:系统参数dao的实现类
 * @author:zyz
 * @time:2020/7/12-16:02
 */
@Repository
public class SystemParamDaoImpl extends AbstractSystemParamDao {
    @Autowired
    SystemParamMapper systemParamMapper;


}
