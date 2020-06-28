package com.bosssoft.hr.train.springboot.basic.example.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @class UserQuery
 * @classdesc 定义组合查询条件，在命名上定义为Query本质为DTO
 * @author Administrator
 * @date 2020-6-19  10:53
 * @version 1.0.0
 * @see
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyQuery extends BaseQuery {
    /**
     * 对应查询条件的姓名支持模糊查询
     */
    private String name;
}
