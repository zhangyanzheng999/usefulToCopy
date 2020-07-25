package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.boss.bes.system.manage.pojo.entity.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-22:16
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleDTO extends BaseDTO {
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
