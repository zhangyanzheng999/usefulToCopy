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
@Table(name = "`tb_company`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {
    /**
     * 公司名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 公司编号
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 助记码
     */
    @Column(name = "`mnemonic_code`")
    private String mnemonicCode;

    /**
     * 法人
     */
    @Column(name = "`master`")
    private String master;

    /**
     * 税号
     */
    @Column(name = "`tax`")
    private String tax;

    /**
     * 传真
     */
    @Column(name = "`fax`")
    private String fax;

    /**
     * 电话
     */
    @Column(name = "`telephone`")
    private String telephone;

    /**
     * address
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 邮箱
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 网址
     */
    @Column(name = "`website`")
    private String website;

    /**
     * 组织机构ID
     */
    @Column(name = "`organization_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @Transient
    private String organizationName;

}