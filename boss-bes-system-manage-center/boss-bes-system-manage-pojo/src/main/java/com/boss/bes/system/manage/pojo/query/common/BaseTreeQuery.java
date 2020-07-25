package com.boss.bes.system.manage.pojo.query.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:通用树的查询/或者用来需要数据隔离的查询
 * @author:zyz
 * @time:2020/7/18-21:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseTreeQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;
}
