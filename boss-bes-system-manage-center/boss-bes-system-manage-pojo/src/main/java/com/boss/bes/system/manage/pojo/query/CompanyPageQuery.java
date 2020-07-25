package com.boss.bes.system.manage.pojo.query;


import com.boss.bes.system.manage.pojo.query.common.BasePageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:这个主要是用来进行查询 传入组织id
 * @author:zyz
 * @time:2020/7/9-11:06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanyPageQuery extends BasePageQuery {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;
}
