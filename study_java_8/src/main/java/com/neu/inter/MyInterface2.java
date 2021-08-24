package com.neu.inter;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/19-21:59
 */
@FunctionalInterface
public interface MyInterface2<T, R> {
    R getValue(T num1, T num2);
}
