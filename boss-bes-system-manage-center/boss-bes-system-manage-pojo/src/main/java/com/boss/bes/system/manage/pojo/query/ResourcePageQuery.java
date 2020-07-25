package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:资源的查询类
 * @author:zyz
 * @time:2020/7/10-20:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResourcePageQuery extends BasePageQuery {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

}
