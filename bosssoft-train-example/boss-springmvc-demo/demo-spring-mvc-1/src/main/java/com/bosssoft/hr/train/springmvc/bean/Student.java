package com.bosssoft.hr.train.springmvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--22:24
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
