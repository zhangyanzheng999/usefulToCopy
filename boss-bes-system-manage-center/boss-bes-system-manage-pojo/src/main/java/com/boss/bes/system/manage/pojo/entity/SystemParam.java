package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_system_param`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SystemParam extends BaseEntity {
    /**
     * 参数类型
     */
    @Column(name = "`param_type`")
    private String paramType;

    /**
     * 参数项
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 参数值
     */
    @Column(name = "`value`")
    private String value;
}