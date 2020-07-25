package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/7/14-16:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DictionaryPageQuery extends BasePageQuery {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    private String category;
}
