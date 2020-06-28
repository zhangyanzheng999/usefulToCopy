package com.bosssoft.hr.train.j2se.basic.example.collection;


/**
 * queue的测试
 * @param <T>
 */
public interface QueueExample<T> {
    /**
     * 添加，队列放入尾部 如果队列已满抛出异常
     * @param user
     * @return
     */
    boolean add(T user);

    /**
     * 添加，队列放入尾部 如果队列已满返回false
     * @param user
     * @return
     */
    boolean offer(T user);

    /**
     * 删除头结点，如果队列为空抛出异常NoSuchElementException
     * @return
     */
    T remove();

    /**
     * 删除头结点，如果队列为空返回null
     * @return
     */
    T poll();

    /**
     * 获取头结点 如果队列为空抛出NoSuchElementException异常
     * @return
     */
    T element();

    /**
     * 获取头结点 如果队列为空返回null
     * @return
     */
    T peek();

}
