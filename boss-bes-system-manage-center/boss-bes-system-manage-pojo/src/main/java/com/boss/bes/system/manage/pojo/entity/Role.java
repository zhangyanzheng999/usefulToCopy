package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Mybatis Generator on 2020/07/04
 */
@Table(name = "`tb_role`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
    /**
     * 角色名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 角色代码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 组织ID
     */
    @Column(name = "`organization_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @Transient
    private String organizationName;

    private List<Company> companyList;
}