package com.bosssoft.hr.train.springmvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @description:
 * @author:zyz
 * @time:2020/6/6--12:45
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
