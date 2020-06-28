package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    //使用@Value赋值：
    //1.基本数值
    //2.写SpEL:#{}
    //3.写${}:取出配置文件【properties】中的值(在运行的环境变量里边的值)
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("${person.nickName}")
    private  String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
