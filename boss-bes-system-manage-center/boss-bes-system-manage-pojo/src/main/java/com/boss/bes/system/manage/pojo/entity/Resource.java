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
@Table(name = "`tb_resource`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Resource extends BaseEntity {
    /**
     * 节点名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 编号
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 顺序号
     */
    @Column(name = "`order_index`")
    private Integer orderIndex;

    /**
     * 父亲节点
     */
    @Column(name = "`parent_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 父节点名字
     */
    @Transient
    private String parentName;

    /**
     * URL
     */
    @Column(name = "`url`")
    private String url;

    /**
     * 打开图标
     */
    @Column(name = "`open_img`")
    private String openImg;

    /**
     * 关闭图标
     */
    @Column(name = "`close_img`")
    private String closeImg;

    /**
     * 资源类型
     */
    @Column(name = "`resource_type`")
    private Integer resourceType;

    /**
     * 叶子节点
     */
    @Column(name = "`leaf`")
    private Boolean leaf;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;
}