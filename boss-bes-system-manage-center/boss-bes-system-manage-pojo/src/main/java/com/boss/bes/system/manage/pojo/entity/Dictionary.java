package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
* Created by Mybatis Generator on 2020/07/14
*/
@Table(name = "`tb_dictionary`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dictionary extends BaseEntity {
    /**
     * 字典名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 字典类型
     */
    @Column(name = "`category`")
    private String category;

    /**
     * 字典值
     */
    @Column(name = "`value`")
    private String value;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 机构ID
     */
    @Column(name = "`organization_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;


}