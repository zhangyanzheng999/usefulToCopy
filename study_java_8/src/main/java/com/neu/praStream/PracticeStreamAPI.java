package com.neu.praStream;

import com.neu.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/20-17:03
 */
public class PracticeStreamAPI {

    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list1 = list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(list1);

    }

    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99, Employee.Status.FREE),
            new Employee("lisi", 38, 5555.55, Employee.Status.BUSY),
            new Employee("wangwu", 50, 6666.66, Employee.Status.VOCATION),
            new Employee("zhaoliu", 16, 3333.33, Employee.Status.FREE),
            new Employee("tianqi", 8, 7777.77, Employee.Status.BUSY));

    @Test
    public void test02() {
        Optional<String> str = employees.stream()
                .map(Employee::getName)
                .sorted(String::compareToIgnoreCase)
                .reduce(String::concat);
        System.out.println(str.get());


        double sum = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(sum);

        Optional<Employee> employee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(employee.get());
    }
}
