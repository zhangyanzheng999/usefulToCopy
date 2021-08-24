package com.neu.innerInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @description: java8内置的四大核心函数式接口：
 * Consumer<T>: 消费型接口
 * void accept(T t);
 * Supplier<T>: 供给型接口
 * T get();
 * Function<T,R>:函数型接口
 * R apply<T t>;
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 * @author:zyz
 * @time:2021/6/19-22:07
 */
public class TestLambda {
    //Consumer<T>
    @Test
    public void test01() {
        happy(1000, (x) -> System.out.println("消费了:" + x));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
    //Supplier<T> 接口

    @Test
    public void test02() {
        getNumList(10, () -> (int) (Math.random() * 100))
                .stream()
                .forEach(System.out::println);
    }

    // 产生指定个数整数并放入到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // Function<T,R>
    @Test
    public void test03() {
        String newStr = handleStr("\t\t\t Hello World!", (str) -> str.trim());
        System.out.println(newStr);
    }

    // 用于处理字符串
    public String handleStr(String str, Function<String, String> function) {
        return function.apply(str);
    }


    //Predicate<T>
    @Test
    public void test04() {
        filterStr(Arrays.asList(
                "zyz",
                "yhy",
                "Hello"), (x) -> x.length() <= 3).stream().forEach(System.out::println);
    }

    // 将满足条件的字符串放入集合中去
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        // List<String> strList = new ArrayList<>();
        List<String> strList = list.stream()
                .filter(x -> predicate.test(x))
                .collect(Collectors.toList());
        return strList;
    }
}
