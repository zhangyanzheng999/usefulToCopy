package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/16-15:52
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer personId;
    private String name;
    private Integer age;
    private String message;

}
