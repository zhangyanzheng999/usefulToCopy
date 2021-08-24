package com.neu.praLambda;

import com.neu.inter.MyFunction;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;


/**
 * @description: Java8引入的一个新的操作符"->"，该操作符称为箭头操作符或者Lambda操作符，
 * "->"将lambda表达式分为两部分：
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需要执行的功能，Lambda体
 * 函数式接口：只有一个方法
 * 语法格式一： 无参数，无返回值
 * () -> System.out.println("Hello Lambda")
 * 语法格式二：有一个参数但是无返回值
 * Consumer<String> con = (x) -> System.out.println(x);
 * Consumer<String> con = System.out::println;
 * 语法格式三：         只有一个参数，小括号可以不写
 * 语法格式四： 有两个以上参数，有返回值，并且Lambda体中有多条语句，必须写{}和return
 * 语法格式五：有两个以上参数，有返回值，但是只有一条语句,return 和{}都可以省略不写
 * 语法格式六：Lambda表达式的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”。
 * 如果写类型，所有参数就必须都写。
 * <p>
 * <p>
 * 二、Lambda表达式需要函数式接口的支持，若接口中只有一个抽象方法，那么就称为函数式接口。可以使用注解@FunctionalInterface修饰可以检查是否是函数式接口
 * @author:zyz
 * @time:2021/6/19-13:12
 */
public class TestLambda2 {

    @Test
    public void test01() {
        //jdk 1.7之前，必须是 final
        // jdk 1.8可以不加，但是默认还是final
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World :" + num);
            }
        };
        r.run();


        Runnable r1 = () -> System.out.println("Hello World" + num);
        r1.run();
    }

    @Test
    public void test02() {
        Consumer<String> con = System.out::println;
        //Consumer<String> con = (x) -> System.out.println(x);
        con.accept("zyz");
    }

    @Test
    public void test04() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("多条语句哦");
            return Integer.compare(x, y);
        };
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

    }


    //需求，对一个数进行运算
    @Test
    public void test05() {
        Integer num = operation(100, (x) -> {
            x = x / 10;
            return x * x;
        });
        System.out.println(num);
    }

    public Integer operation(Integer num, MyFunction mf) {

        return mf.getValue(num);
    }
}
