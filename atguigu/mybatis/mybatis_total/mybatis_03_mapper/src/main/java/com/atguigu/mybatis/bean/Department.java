package com.atguigu.mybatis.bean;


import java.util.List;


/**
 * @description:
 * @author:zyz
 * @time:2020/5/22--11:03
 */
public class Department {
    private Integer id;
    private String deptName;
    private List<Employee> emps;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }


}