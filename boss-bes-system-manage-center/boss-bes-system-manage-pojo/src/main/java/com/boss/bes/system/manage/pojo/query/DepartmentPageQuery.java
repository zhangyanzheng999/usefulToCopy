package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:部门的query，需要传入部门级别和公司Id
 * @author:zyz
 * @time:2020/7/9-16:34
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentPageQuery extends BasePageQuery {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private String level;
}
