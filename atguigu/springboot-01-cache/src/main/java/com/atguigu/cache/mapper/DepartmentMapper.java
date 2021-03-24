package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author:zyz
 * @time:2021/3/22-13:13
 */
public interface DepartmentMapper {
    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);
}
