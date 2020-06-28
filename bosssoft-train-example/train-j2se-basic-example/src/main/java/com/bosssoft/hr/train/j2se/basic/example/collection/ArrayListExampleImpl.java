package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description: 演示集合类的增删改查从操作
 * @author: Administrator
 * @create: 2020-05-22 14:40
 * @since
 **/

@Slf4j
public class ArrayListExampleImpl implements ArrayListExample<User> {
    /**
     * =============================》ArrayListExample
     * 演示的arrayList对象
     */
    private List<User> users = new ArrayList<>();

    /**
     * 这里开始 关于 arraylist的主要方法测试
     *
     * @param node
     * @return
     */
    public boolean append(User node) {
        return users.add(node);
    }

    public User get(Integer index) {
        return index >= 0 && index < users.size() ? users.get(index) : null;
    }

    public boolean insert(Integer position, User user) {
        // 我认为 position==users.size() 时代表尾插
        if (position >= 0 && position <= users.size()) {
            users.add(position, user);
            return true;
        } else
            return false;

    }

    public boolean remove(Integer position) {
        return (position >= 0 && position < users.size()) && users.remove(position.intValue()) != null;
    }

    public void listByIndex() {
        int size = users.size();
        for (int i = 0; i < size; i++) {
            log.info(Constraint.LOG_TAG, users.get(i));
            /* 注意 如果在for遍历过程中作删除操作将导致异常 元素删除前移导致*/
            /** 以下代码被禁止
             if(users.get(i).getName().equalsIgnoreCase("jim")){
             users.remove(i);
             }
             */
        }

    }


    /**
     * 迭代 不要使用for
     */
    public void listByIterator() {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            log.info(Constraint.LOG_TAG, iterator.next());
        }

    }

    /**
     *  注意要用 toArray(T[] a)
     * @return
     */
    public User[] toArray() {
        return users != null ?  users.toArray(new User[users.size()]) : null;
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

        users.sort((Comparator.comparingInt(User::getId)));
    }


}
