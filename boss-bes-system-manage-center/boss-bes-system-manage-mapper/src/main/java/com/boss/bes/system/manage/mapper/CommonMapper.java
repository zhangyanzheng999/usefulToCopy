package com.boss.bes.system.manage.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:抽象出公用的Mapper
 * @author:zyz
 * @time:2020/7/6-18:13
 */
@RegisterMapper
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
