package com.atguigu.mybatis.service;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/24--14:01
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;


    public List<Employee> emps(){
        // 批量执行
      // EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


        List<Employee> emps = employeeMapper.getEmps();
        return emps;
    }
}
