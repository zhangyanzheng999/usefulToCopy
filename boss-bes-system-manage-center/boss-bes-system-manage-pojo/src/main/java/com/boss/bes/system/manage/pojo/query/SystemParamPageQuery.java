package com.boss.bes.system.manage.pojo.query;

import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import lombok.*;

/**
 * @description:系统参数的分页查询
 * @author:zyz
 * @time:2020/7/14-20:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SystemParamPageQuery extends BasePageQuery {

    private String paramType;
}
