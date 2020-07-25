package com.boss.bes.system.manage.dao;




import com.boss.bes.system.manage.pojo.entity.Department;

import java.util.List;

/**
 * @description:部门信息的dao层
 * @author:zyz
 * @time:2020/7/9-14:43
 */
public interface DepartmentDao {
    Department query(Long id, Long version);


    List<Department> queryAllWithPageAndCompany(String name, Long companyId,Long organizationId,Long parentId);
}
