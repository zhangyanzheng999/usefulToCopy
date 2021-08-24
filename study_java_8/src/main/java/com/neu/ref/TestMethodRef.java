package com.neu.ref;

import com.neu.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description: 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * (可以理解为方法引用是Lambda表达式的另外一种表达方法)
 * 主要由三种表现形式
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 注意：
 * 参数列表与返回类型 要与调用方法的保持一致
 * 若Lambda参数列表中，第一个参数是实例方法的调用者，第二个参数是实例方法参数时，可以使用类名::实例方法名
 * <p>
 * <p>
 * <p>
 * 二、构造器引用：
 * 格式：
 * ClassName::new
 *
 * 三、数组引用
 *  type::new;
 * @author:zyz
 * @time:2021/6/19-22:32
 */
public class TestMethodRef {
    // 对象::实例方法名
    @Test
    public void test01() {
        // 参数列表与返回类型 要与调用方法的保持一致
        Consumer<String> consumer = (x) -> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("hello");
    }

    @Test
    public void test02() {
        Employee emp = new Employee();
        Supplier<String> supper = () -> emp.getName();
        Supplier<String> supper2 = emp::getName;
        System.out.println(supper2.get());
    }

    // 类::静态方法名
    @Test
    public void test03() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator1 = Integer::compare;
    }


    // 类::实例方法名
    @Test
    public void test04() {
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> biPredicate1 = String::equals;
        biPredicate1.test("zyz", "zyz");
    }

    // 构造器引用
    @Test
    public void test05() {
        Supplier<Employee> supplier = () -> new Employee();

        // 构造器引用方法 ,调用的构造方法 需要看参数列表
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee);


        Function<Integer,Employee> function = Employee::new;
        System.out.println(function.apply(22));
    }

    //数组引用
    @Test
    public void test06(){
        Function<Integer,String[]> function = (x)->new String[x];
        String[] stringList = function.apply(10);
        System.out.println(stringList.length);

        Function<Integer,String[]> function1 = String[]::new;
        System.out.println(function1.apply(20).length);
    }
}
