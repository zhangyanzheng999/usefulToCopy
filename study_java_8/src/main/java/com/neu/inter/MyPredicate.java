package com.neu.inter;

/**
 * @description:
 * @author:zyz
 * @time:2021/6/18-16:59
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean filter(T t);
}
