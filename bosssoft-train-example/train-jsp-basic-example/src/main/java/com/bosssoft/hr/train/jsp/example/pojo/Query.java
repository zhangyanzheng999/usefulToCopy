package com.bosssoft.hr.train.jsp.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-29 14:09
 * @since
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    /**
     * 用来模糊搜索
     */
    private String name;
    /**
     * 用来查询账号密码
     */
    private String code;
    private String password;

    /**
     * 根据name模糊搜索
     *
     * @param tableName
     * @return
     */
    public String listNameLikes(String tableName) {
        String userName = "%" + this.getName() + "%";
        return "select * from " + tableName + " where name like " + "'" + userName + "'";
    }

    /**
     * 验证账号密码
     *
     * @param tableName
     * @return
     */
    public String getUserByCodeAndPassword(String tableName) {
        String userCode = this.getCode();
        String userPassword = this.getPassword();
        if (userCode != null && userPassword != null) {
            return "select * from " + tableName + " where code=" + "'" + userCode + "'" + " and password=" + "'" + userPassword + "'" + "";
        }
        return null;
    }

    public Query(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public Query(String name) {
        this.name = name;
    }

    public Query(User user) {
        this.code = user.getCode();
        this.password = user.getPassword();
    }

    @Override
    public String toString() {
        return "Query{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
