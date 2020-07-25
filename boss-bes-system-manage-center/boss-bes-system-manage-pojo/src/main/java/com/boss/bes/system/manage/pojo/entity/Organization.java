package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_organization`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Organization extends BaseEntity {
    /**
     * 机构名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 机构代码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 负责人
     */
    @Column(name = "`master`")
    private String master;

    /**
     * 电话
     */
    @Column(name = "`tel`")
    private String tel;

    /**
     * 地址
     */
    @Column(name = "`address`")
    private String address;
}