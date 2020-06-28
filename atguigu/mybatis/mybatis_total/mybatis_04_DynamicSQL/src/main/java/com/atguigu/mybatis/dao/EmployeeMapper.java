package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/20--16:05
 */
public interface EmployeeMapper {
     //多条记录封装一个map,Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
     //告诉mybatis封装这个map的时候使用哪个属性作为map的key
     @MapKey("id")
     Map<Integer,Employee> getEmpsByLastNameLikeReturnMap(String lastName);

     //返回一条记录的map: key是列名，值是对应的值
     Map<String,Object> getEmpByIdReturnMap(Integer id);


     Employee getEmpById(Integer id);
     Employee getEmpByList(List<String> list);
     Employee getEmpByMap(Map<String, Object> map);
     Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);
     List<Employee> getEmpsByLastNameLike(String lastName);
     void addEmp(Employee employee);
     void updateEmp(Employee employee);
     void deleteEmpById(Integer id);


}
