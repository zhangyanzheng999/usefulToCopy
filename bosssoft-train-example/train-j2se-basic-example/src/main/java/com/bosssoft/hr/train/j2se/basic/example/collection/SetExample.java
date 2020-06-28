package com.bosssoft.hr.train.j2se.basic.example.collection;

import java.util.Collection;
import java.util.Iterator;

public interface SetExample<T> {
    /**
     * 返回元素个数
     *
     * @return
     */
    int size();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 判断是否包含某个元素
     *
     * @param o
     * @return
     */
    boolean contains(T o);

    /**
     * 获取迭代器
     *
     * @return
     */
    Iterator iterator();

    /**
     * 添加元素
     *
     * @param o
     * @return
     */
    boolean add(T o);

    /**
     * 删除指定元素
     * @param o
     * @return
     */
    boolean remove(T o);

    /**
     * 添加Collection
     * @param c
     * @return
     */
    boolean addAll(Collection c);

    /**
     * 清空set
     */
    void clear();

}
