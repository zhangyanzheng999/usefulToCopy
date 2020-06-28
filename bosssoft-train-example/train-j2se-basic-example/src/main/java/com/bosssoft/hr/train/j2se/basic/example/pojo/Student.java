package com.bosssoft.hr.train.j2se.basic.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:07
 * @since
 **/
@NoArgsConstructor
public class Student extends User {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Student(Integer id, String name) {
        super(id, name);
    }

    public Student(Integer id, String name, Integer age) {
        super(id, name);
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Student{ Id:" + getId() + ",Name:" + getName() + ",Age:" + getAge() + "}";
    }
}
