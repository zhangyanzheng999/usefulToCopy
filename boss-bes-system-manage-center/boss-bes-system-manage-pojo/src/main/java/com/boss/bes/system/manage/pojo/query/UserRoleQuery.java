package com.boss.bes.system.manage.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:查询某公司Id下的已分配角色的用户
 * @author:zyz
 * @time:2020/7/17-8:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
}
