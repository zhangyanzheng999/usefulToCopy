package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;

    private String name;

    @Max(value = 120, message = "年龄最大为120")
    @Min(value = 0, message = "年龄最小为0")
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }




}