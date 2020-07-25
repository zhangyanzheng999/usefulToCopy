package com.boss.bes.system.manage.mapper;

import com.boss.bes.system.manage.pojo.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper extends CommonMapper<Department> {
    List<Department> queryAllWithPageAndCompany(@Param("name") String name,
                                                @Param("companyId") Long companyId,
                                                @Param("organizationId") Long organizationId,
                                                @Param("parentId") Long parentId);


    String getDeptName(Long id);

    Department getDepartment(@Param("id") Long id, @Param("version") Long version);
}