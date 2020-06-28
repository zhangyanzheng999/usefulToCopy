package com.bosssoft.hr.train.springboot.basic.example.dao.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-06-26 14:18
 * @since
 **/
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
