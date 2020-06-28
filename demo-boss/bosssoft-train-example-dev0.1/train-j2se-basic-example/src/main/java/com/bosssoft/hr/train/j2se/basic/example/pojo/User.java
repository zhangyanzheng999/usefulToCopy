package com.bosssoft.hr.train.j2se.basic.example.pojo;

import lombok.Data;


/**
 * @param
 * @description: 判断对象相等重写 equals 和 hashcode 很重要哦
 *           加上@Data 注解不再需要编写
 * @author: Administrator
 * @create: 2020-05-22 14:52
 * @since
 **/
@Data
public class User {
    private Integer id;
    private String name;


}
