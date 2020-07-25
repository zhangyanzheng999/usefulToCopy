package com.boss.bes.system.manage.pojo.entity;

import com.boss.bes.system.manage.pojo.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by Mybatis Generator on 2020/07/04
 */
@Table(name = "`tb_user`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    /**
     * 工号
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 名字
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 头像
     */
    @Column(name = "`profile_picture`")
    private String profilePicture;

    /**
     * 性别
     */
    @Column(name = "`sex`")
    private Integer sex;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "`birthday`")
    private Date birthday;

    /**
     * 电话
     */
    @Column(name = "`tel`")
    private String tel;

    /**
     * 邮箱
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 其他联系
     */
    @Column(name = "`other`")
    private String other;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    /**
     * 用户部门
     */
    @Column(name = "`department_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long departmentId;
    @Transient
    private String departmentName;
    /**
     * 用户职位
     */
    @Column(name = "`position_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long positionId;

    @Transient
    private String positionName;

    @Transient
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
    @Transient
    private String companyName;




    private List<Role> roles;
}