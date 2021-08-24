package com.neu.praLambda;

import com.neu.bean.Employee;
import com.neu.inter.MyInterface;
import com.neu.inter.MyInterface2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/19-21:49
 */
public class TestLambda3 {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 38, 5555.55),
            new Employee("wangwu", 50, 6666.66),
            new Employee("wangwu2", 50, 6666.66),
            new Employee("zhaoliu", 16, 3333.33),
            new Employee("tianqi", 8, 7777.77)
    );

    @Test
    public void test01() {
        Collections.sort(employees, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            }
            return Integer.compare(x.getAge(), y.getAge());
        });
        employees.forEach(System.out::println);
    }


    @Test
    public void test02() {
        String str = operationString("zyz", (x) -> x.toUpperCase());
        System.out.println(str);
        str = operationString("Hello World", (x) -> x.substring(2, 5));
        System.out.println(str);
    }

    public String operationString(String str, MyInterface mi) {
        return mi.getValue(str);
    }


    public void operationLong(Long num1, Long num2, MyInterface2<Long, Long> mi) {
        System.out.println(mi.getValue(num1, num2));
    }
}
