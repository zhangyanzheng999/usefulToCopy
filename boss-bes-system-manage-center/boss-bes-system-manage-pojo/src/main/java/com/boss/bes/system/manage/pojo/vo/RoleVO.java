package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.entity.Company;
import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

/**
 * @description:角色类的VO
 * @author:zyz
 * @time:2020/7/3-21:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleVO extends BaseVO {
    /**
     * 角色名
     */
    private String name;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 备注
     */
    private String remark;

    /**
     * 组织ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    private String organizationName;

    private List<Company> companyList;
}
