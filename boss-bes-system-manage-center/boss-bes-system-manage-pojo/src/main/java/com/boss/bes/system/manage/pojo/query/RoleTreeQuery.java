package com.boss.bes.system.manage.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:角色树的查询条件
 * @author:zyz
 * @time:2020/7/17-15:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleTreeQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
}
