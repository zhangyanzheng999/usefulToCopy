package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:用户的查询VO
 * @author:zyz
 * @time:2020/7/16-14:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleQuery extends BaseQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
}
