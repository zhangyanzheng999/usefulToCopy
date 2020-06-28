package com.boss.learning.springlog.bean;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/3--19:41
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
