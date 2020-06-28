package com.bosssoft.hr.train.springmvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--16:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    /**
     * 不能包含#
     */
    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
