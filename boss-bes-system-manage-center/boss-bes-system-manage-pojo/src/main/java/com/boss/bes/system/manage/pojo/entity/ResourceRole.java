package com.boss.bes.system.manage.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_resource_role`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRole {
    @Id
    @Column(name = "`role_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    @Id
    @Column(name = "`resource_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long resourceId;
}