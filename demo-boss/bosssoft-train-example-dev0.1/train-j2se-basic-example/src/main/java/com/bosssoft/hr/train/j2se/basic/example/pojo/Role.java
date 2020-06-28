package com.bosssoft.hr.train.j2se.basic.example.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * @description: 角色
 * @author: Administrator
 * @create: 2020-05-28 20:42
 * @since
 **/
@Data
public class Role {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     *  当 Role 作为 Map类测试的Key时要求必须不重复，所以重写以下方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
