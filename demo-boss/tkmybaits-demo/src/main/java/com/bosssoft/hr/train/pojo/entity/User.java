package com.bosssoft.hr.train.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 如果实体类中没有一个标记 @Id 的字段，
 * 当你使用带有 ByPrimaryKey 的方法时，所有的字段会作为联合主键来使用，
 * 也就会出现类似 where id = ? and countryname = ? and countrycode = ? 的情况。
 * @author:zyz
 * @time:2020/6/22-11:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private Integer age;
}
