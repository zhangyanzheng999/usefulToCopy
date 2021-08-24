package com.neu.praStream;

import com.neu.bean.Employee;
import com.neu.bean.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 终止操作：
 * 查找与匹配：
 * allMatch:检测是否匹配所有元素
 * anyMatch:检查是否至少匹配一个元素
 * noneMatch:检查是否没有匹配所有元素
 * findFirst:返回第一个元素
 * findAny:返回任意一个元素
 * count:返回流中元素个数
 * max:返回最大值
 * min:返回最小值
 * 归约：可以将流中元素反复结合起来，得到一个值
 * reduce(T identity, BinaryOperator<T> accumulator)
 * reduce(BinaryOperator<T> accumulator);
 * reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
 * 收集：
 * collect--将流转化为其他形式。接收一个Collector接口的实现，用于给Stream中元素汇总的方法
 * @author:zyz
 * @time:2021/6/20-13:46
 */
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99, Status.FREE),
            new Employee("lisi", 38, 5555.55, Status.BUSY),
            new Employee("wangwu", 50, 6666.66, Status.VOCATION),
            new Employee("zhaoliu", 16, 3333.33, Status.FREE),
            new Employee("tianqi", 8, 7777.77, Status.BUSY));

    List<Employee> emps = Arrays.asList(
            new Employee("zhangsan", 18, 19999.99, Status.FREE),
            new Employee("zhangsan", 28, 39999.99, Status.FREE),
            new Employee("zhangsan", 38, 59999.99, Status.FREE),
            new Employee("lisi", 38, 5555.55, Status.BUSY),
            new Employee("wangwu", 50, 6666.66, Status.VOCATION),
            new Employee("zhaoliu", 16, 3333.33, Status.FREE),
            new Employee("tianqi", 8, 7777.77, Status.BUSY));

    @Test
    public void test01() {
        boolean result = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        Optional<Employee> employee = employees.stream()
                //.sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()))
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(employee.get());


        Optional<Employee> employee1 = employees.stream()
                .filter((e) -> e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(employee1.orElse(new Employee()));


        employees.stream()
                .map(Employee::getSalary)
                .max(Double::compare);
    }

    // reduce
    @Test
    public void test03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);


        Optional<Double> allSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(allSalary.get());
    }

    //收集
    @Test
    public void test04() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        HashSet<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        long count = employees.stream()
                .map(Employee::getName)
                .count();
        Long count2 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.counting());
        System.out.println(list);
        System.out.println(set);

        OptionalDouble average = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .average();
        System.out.println(average);

        Double average1 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(average1);
    }

    @Test
    public void test05() {
        Optional<Employee> employee = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee.get());
        Optional<Employee> employee1 = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(employee1.get());
    }

    //分组
    @Test
    public void test06() {
        Map<Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        Iterator<Status> key = map.keySet().iterator();
        while (key.hasNext()) {
            System.out.println(map.get(key.next()));
        }
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

    }

    @Test
    public void testGroupBy() {
        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.summingDouble(Employee::getSalary)));
        //map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));


        HashMap<String, List<Integer>> map1 = emps.stream()
                .collect(HashMap::new, (tempMap, e) -> tempMap.put(e.getName(), Arrays.asList(e.getAge())), HashMap::putAll);
        System.out.println(map1);
        Map<String, List<Integer>> map2 = emps.stream()
                .collect(Collectors.toMap(Employee::getName, e -> new ArrayList<>(Arrays.asList(e.getAge())), (oldValue, newValue) -> {
                    oldValue.addAll(newValue);
                    return oldValue;
                }));
        System.out.println(map2);
    }

    //多级分组
    @Test
    public void test07() {
        Map<Status, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    //分片
    @Test
    public void test08() {
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 6000));
        System.out.println(map);
    }


    @Test
    public void test09() {
        DoubleSummaryStatistics ds = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(ds.getAverage());
    }


    @Test
    public void test10() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));
        System.out.println(str);
    }
}
