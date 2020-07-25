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
@Table(name = "`tb_position`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Position extends BaseEntity {
    /**
     * 职位名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 职位编号
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 公司ID
     */
    @Column(name = "`company_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @Transient
    private String companyName;
}