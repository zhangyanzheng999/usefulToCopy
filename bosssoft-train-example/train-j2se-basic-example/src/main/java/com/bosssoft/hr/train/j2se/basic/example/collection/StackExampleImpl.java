package com.bosssoft.hr.train.j2se.basic.example.collection;


import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/29--16:05
 */
public class StackExampleImpl implements StackExample<User> {
    Deque<User> users = new ArrayDeque<>();

    @Override
    public User push(User item) {
        users.addLast(item);
        return item;
    }

    @Override
    public User pop() {
        return users.removeLast();
    }

    @Override
    public User peek() {
        return users.peek();
    }

    @Override
    public boolean empty() {
        return users.isEmpty();
    }


    public Deque<User> getUsers() {
        return users;
    }

    public void setUsers(Deque<User> users) {
        this.users = users;
    }
}
