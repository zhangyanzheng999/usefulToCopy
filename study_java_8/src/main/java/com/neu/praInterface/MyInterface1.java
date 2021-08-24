package com.neu.praInterface;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/20-23:42
 */
public interface MyInterface1 {
    default String getName() {
        return "interface 1";
    }


    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
