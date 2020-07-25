package com.boss.bes.system.manage.pojo.query.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 分页查询的基本实现
 * @author:zyz
 * @time:2020/7/4-9:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasePageQuery{
    private Integer pageNum;
    private Integer pageSize;
    private String name;

    public Integer getPageNum() {
        return pageNum > 0 ? pageNum : 5;
    }

    public Integer getPageSize() {
        return pageSize > 0 ? pageSize : 1;
    }

    public String getName() {
        return name == null ? "" : name;
    }
}
