/**
 * @file:  BaseEntity.java
 * @author: Administrator    
 * @date:   2020-6-19 11:22
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.bosssoft.hr.train.springboot.basic.example.pojo.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * @class BaseEntity
 * @classdesc 系统表包含的公用字段进行提取，统一切面也将使用该类型
 *
 * @author Administrator
 * @date 2020-6-19  10:39
 * @version 1.0.0
 * @see
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {
   @Id
    /**
     *  主键
     */
    private Long id;
    private Byte status;
    /**
     * 记录所属公司ID
     */
    private Long companyId;
    /**
     * 组织机构ID ，一个组织机构包含多个公司
     */
    private Long organizationId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    private Long createdBy;
    /**
     *  更新时间记录便于追踪
     */
    private Date updatedTime;
    /**
     *  更新人ID 后续的update更新此字典
     */
    private Long updatedBy;
    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    private Long version;

    @Override
    public boolean equals(Object o) {        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
