package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/7--20:49
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer userId;
    private String userName;


    private Company company;
    private Set<Role> roles;




    public String toStringWithCompany() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", company=" + company +
                '}';
    }


    public String toStringWithRole() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", roles=" + roles +
                '}';
    }


}
