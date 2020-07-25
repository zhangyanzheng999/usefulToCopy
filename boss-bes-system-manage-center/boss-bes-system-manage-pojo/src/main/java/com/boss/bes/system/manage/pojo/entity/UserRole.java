package com.boss.bes.system.manage.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
* Created by Mybatis Generator on 2020/07/04
*/
@Table(name = "`tb_user_role`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @Column(name = "`user_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @Id
    @Column(name = "`role_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;



}