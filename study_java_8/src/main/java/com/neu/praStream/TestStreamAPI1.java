package com.neu.praStream;

import com.neu.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: 一、Stream的三个步骤
 * 1.创建Stream
 * <p>
 * 2.中间操作
 * <p>
 * 3.终止操作
 * @author:zyz
 * @time:2021/6/20-0:02
 */
public class TestStreamAPI1 {
    // Stream
    @Test
    public void test01() {
        //1.可以通过Collection系列集合提供的stream() 串行流或者parallelStream() 并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream类中的of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);

        //stream4.limit(10).forEach(System.out::println);
        //生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(5).forEach(System.out::println);
    }
}
