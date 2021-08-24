package com.neu.praStream;

import com.neu.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: 中间操作：
 * 1.筛选与切片
 * filter:接收Lambda，过滤
 * limit:截断流，使其元素不超过给定数量
 * skip(n):跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，那么返回一个空流
 * distinct:去重，整体去重
 * 2.映射
 * map:接收Lambda，将元素转化为其他形式或提取信息。接收一个函数作为参数，该函数会被映射到每个元素上，并将其映射成一个新的元素
 * flatMap:接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流
 * 3.排序
 * sorted()：自然排序  按照对象实现的Comparable接口的compareTo()排序
 * sorted(Comparator com):定制排序规则 Comparator
 * @author:zyz
 * @time:2021/6/20-0:24
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 38, 5555.55),
            new Employee("wangwu", 50, 6666.66),
            new Employee("zhaoliu", 16, 3333.33),
            new Employee("tianqi", 18, 7777.77)
    );

    @Test
    public void test01() {
        Stream<Employee> stream = employees.stream().filter(x -> {
            System.out.println("Stream API 的中间操作");
            return x.getAge() > 30;
        });
        // 终止操作
        stream.forEach(System.out::println);
    }


    //映射
    @Test
    public void test02() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
//        list.stream()
//                .map(str -> str.toUpperCase())
//                .forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI2::filterCharacter);
        stream.forEach((sm) -> sm.forEach(System.out::println));


        Stream<Character> stream1 = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        stream1.forEach(System.out::println);
    }


    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    // 排序
    @Test
    public void test03() {
        List<String> list = Arrays.asList("ccc", "bbb", "aaa", "eee", "ddd");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return Integer.compare(e1.getAge(), e2.getAge());
                }).forEach(System.out::println);
    }



    @Test
    public void test04(){

    }
}
