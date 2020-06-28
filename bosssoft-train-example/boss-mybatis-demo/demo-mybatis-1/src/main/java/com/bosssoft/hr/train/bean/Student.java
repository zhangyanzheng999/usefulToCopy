package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * @description:学生类
 * @author:zyz
 * @time:2020/6/7--18:34
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {
    private Integer id;
    private Integer score;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
