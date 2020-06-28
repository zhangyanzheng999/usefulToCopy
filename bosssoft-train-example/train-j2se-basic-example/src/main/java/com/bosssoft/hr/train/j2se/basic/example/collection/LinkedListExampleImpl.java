package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description: 演示linkedList 的增删改查从操作
 * @author: Administrator
 * @create: 2020-05-22 14:40
 * @since
 **/

@Slf4j
public class LinkedListExampleImpl implements LinkedListExample<User> {

    /**
     * =============================》ArrayListExample
     * 演示的linkedList对象
     */
    private LinkedList<User> linkUsers = new LinkedList<>();

    /**
     * 这里开始 关于 linkedList的主要方法测试
     *
     * @param node
     * @return
     */
    public boolean append(User node) {
        return linkUsers.add(node);
    }

    public User get(Integer index) {
        return index >= 0 && index < linkUsers.size() ? linkUsers.get(index) : null;
    }

    public boolean insert(Integer position, User user) {
        // 认为 position 等于 users.size()时相当于尾插
        if (position >= 0 && position <= linkUsers.size()) {
            linkUsers.add(position, user);
            return true;
        } else
            return false;

    }

    public boolean remove(Integer position) {
        return (position >= 0 && position < linkUsers.size()) && linkUsers.remove(position.intValue()) != null;
    }

    public void listByIndex() {
        int size = linkUsers.size();
        for (int i = 0; i < size; i++) {
            log.info(Constraint.LOG_TAG, linkUsers.get(i));
            /* 注意 如果在for遍历过程中作删除操作将导致异常 元素删除前移导致*/
            /** 以下代码被禁止
             if(users.get(i).getName().equalsIgnoreCase("jim")){
             users.remove(i);
             }
             */
        }
    }

    public void listByIterator() {
        Iterator<User> iterator = linkUsers.iterator();
        while (iterator.hasNext()) {
            log.info(Constraint.LOG_TAG, iterator.next());
        }
    }

    public User[] toArray() {
        return linkUsers != null ? linkUsers.toArray(new User[linkUsers.size()]) : null;
    }


    /**
     * 演示
     */
    public void sort() {

        /**
         * what is lambda
         Syntax and Structure
         So, standard syntax of lambda is as follows:

         () -> some expression
         Or
         (arguments) -> { body just like function }
         * why lambda
         * simple and efficiency
         */

        linkUsers.sort((Comparator.comparingInt(User::getId)));
    }

    /**
     * 队列 方法测试 ============================>队列方法测试
     *
     * @param node
     */
    @Override
    public void addFirst(User node) {
        linkUsers.addFirst(node);
    }

    @Override
    public boolean offer(User node) {

        return linkUsers.offer(node);
    }

    @Override
    public void synchronizedVisit(User node) {
        /**
         * 注意采用这种方法实现线程安全
         */
        Collections.synchronizedCollection(linkUsers).add(node);
    }

    @Override
    public void push(User node) {
        linkUsers.push(node);
    }

    @Override
    public User pop() {
        return linkUsers.pop();
    }
}
