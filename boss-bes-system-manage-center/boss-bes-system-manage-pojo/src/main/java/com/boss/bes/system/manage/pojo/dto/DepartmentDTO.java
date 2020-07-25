package com.boss.bes.system.manage.pojo.dto;


import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Transient;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-22:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentDTO extends BaseDTO {
    /**
     * 部门名称
     */
    private String name;

    /**
     * 助记码
     */
    private String mnemonicCode;

    /**
     * 部门编号
     */
    private String code;

    /**
     * 部门级别
     */
    private String level;

    /**
     * 上级部门
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @Transient
    private String parentName;
    /**
     * 负责人
     */
    private String master;

    /**
     * 部门描述
     */
    private String descript;

    /**
     * 公司ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @Transient
    private String companyName;
}
