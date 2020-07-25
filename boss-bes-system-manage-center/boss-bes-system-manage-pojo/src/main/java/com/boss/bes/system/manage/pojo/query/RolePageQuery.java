package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:角色的分页查询类
 * @author:zyz
 * @time:2020/7/11-20:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RolePageQuery extends BasePageQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
}
