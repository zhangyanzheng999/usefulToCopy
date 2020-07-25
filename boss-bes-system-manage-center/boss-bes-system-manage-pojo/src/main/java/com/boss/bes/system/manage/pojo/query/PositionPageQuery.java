package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:职位的分页查询
 * @author:zyz
 * @time:2020/7/12-10:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PositionPageQuery extends BasePageQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    private Boolean status;
}
