package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * @description:
 * @author:zyz
 * @time:2021/3/22-13:13
 */
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Update("Update employee SET lastName = #{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id = #{id}")
    void updateEmp(Employee employee);

    @Delete("Delete FROM employee WHERE id = #{id}")
    void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
