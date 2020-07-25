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
@Table(name = "`tb_company_role`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRole {
    @Id
    @Column(name = "`company_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    @Id
    @Column(name = "`role_id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;
}