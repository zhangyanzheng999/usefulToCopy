package com.neu.praLambda;

import com.neu.bean.Employee;
import com.neu.inter.MyPredicate;
import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/18-16:27
 */
public class TestLambda {

    @Test
    public void test01() {
        // 匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }


    @Test
    public void test02() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator2 = Integer::compare;

        TreeMap<Integer, Integer> tm = new TreeMap<>(comparator);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 38, 5555.55),
            new Employee("wangwu", 50, 6666.66),
            new Employee("zhaoliu", 16, 3333.33),
            new Employee("tianqi", 8, 7777.77)
    );

    //需求：获取当前员工中年龄大于35的员工
    @Test
    public void test03() {
        employees.stream()
                .filter(x -> x.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);


        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);


        employees.stream()
                .map(x->{
                    x.getName();
                    x.getAge();
                    return x.toString();
                }).forEach(System.out::println);
    }

    public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (mp.filter(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    public static void main(String[] args) {

    }
}
