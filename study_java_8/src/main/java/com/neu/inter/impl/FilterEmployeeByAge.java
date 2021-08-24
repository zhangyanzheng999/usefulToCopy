package com.neu.inter.impl;

import com.neu.bean.Employee;
import com.neu.inter.MyPredicate;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/18-17:00
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    public boolean filter(Employee employee) {
        return employee.getAge() >= 35;
    }
}
