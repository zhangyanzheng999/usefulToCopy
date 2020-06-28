package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.User;

import java.util.*;

/**
 * @description: 演示如何使用 比较器排序 ，另外一种方式 User 实现比较接口这种对
 * User 类存在侵入
 * @author: Administrator
 * @create: 2020-05-28 21:56
 * @since
 **/
public class TreeSetExampleImpl implements TreeSetExample<User> {
    private Set<User> set = new TreeSet<>((o1, o2) -> o1.getId() - o2.getId());

    @Override
    public User[] sort(User[] arry) {
        if (null != arry && arry.length > 0) {
            set.addAll(Arrays.asList(arry));
            return set.toArray(new User[set.size()]);
        } else
            return new User[]{};
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(User o) {
        return set.contains(o);
    }

    @Override
    public Iterator<User> iterator() {
        return set.iterator();
    }

    @Override
    public boolean add(User o) {
        return set.add(o);
    }

    @Override
    public boolean remove(User o) {
        return set.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return set.addAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
