package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/14-9:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserPageQuery extends BasePageQuery {
    private String code;
    private String tel;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long departmentId;
}
