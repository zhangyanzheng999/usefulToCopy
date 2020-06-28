package com.bosssoft.hr.train.springmvc.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/5--22:53
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @NotNull
    private Integer id;
    private String lastName;

    @Max(value = 1, message = "值必须为0或1")
    @Min(value = 0, message = "值必须为0或1")
    private Integer gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
