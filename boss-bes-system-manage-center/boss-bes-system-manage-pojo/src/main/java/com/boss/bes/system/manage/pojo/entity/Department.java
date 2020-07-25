package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_department`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {
    /**
     * 部门名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 助记码
     */
    @Column(name = "`mnemonic_code`")
    private String mnemonicCode;

    /**
     * 部门编号
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 部门级别
     */
    @Column(name = "`level`")
    private String level;

    /**
     * 上级部门
     */
    @Column(name = "`parent_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @Transient
    private String parentName;
    /**
     * 负责人
     */
    @Column(name = "`master`")
    private String master;

    /**
     * 部门描述
     */
    @Column(name = "`descript`")
    private String descript;

    /**
     * 公司ID
     */
    @Column(name = "`company_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @Transient
    private String companyName;
}