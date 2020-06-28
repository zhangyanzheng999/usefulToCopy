package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String lastName;
    private Integer gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public User(String lastName, Integer gender) {
        this.lastName = lastName;
        this.gender = gender;
    }
}
