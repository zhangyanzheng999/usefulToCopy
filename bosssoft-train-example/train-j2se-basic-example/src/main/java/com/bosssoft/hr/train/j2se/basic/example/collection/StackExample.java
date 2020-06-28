package com.bosssoft.hr.train.j2se.basic.example.collection;


public interface StackExample<T> {
    /**
     * 插入栈顶
     *
     * @param item
     * @return
     */
    T push(T item);

    /**
     * 弹出栈顶元素并返回
     *
     * @return
     */
    T pop();

    /**
     * 返回栈顶元素
     *
     * @return
     */
    T peek();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean empty();


}
