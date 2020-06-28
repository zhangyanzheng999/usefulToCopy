package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/29--15:55
 */
public class QueueExampleImpl implements QueueExample<User> {
    /**
     * 使用linkedlist代替一下queue吧
     */
    private Queue<User> queue = new LinkedList<>();


    @Override
    public boolean add(User user) {
        return queue.add(user);
    }

    @Override
    public boolean offer(User user) {
        return queue.offer(user);
    }

    @Override
    public User remove() {
        return queue.remove();
    }

    @Override
    public User poll() {
        return queue.poll();
    }

    @Override
    public User element() {
        return queue.element();
    }

    @Override
    public User peek() {
        return queue.peek();
    }

    public Queue<User> getQueue() {
        return queue;
    }

    public void setQueue(Queue<User> queue) {
        this.queue = queue;
    }
}
