package com.neu.praInterface;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/20-23:43
 */
public class MyClass implements MyInterface1,MyInterface2{
    @Override
    public String getName() {
        return MyInterface2.super.getName();
    }
}
