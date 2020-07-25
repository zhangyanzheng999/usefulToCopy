/**
 * @file: BaseEntity.java
 * @author: Administrator
 * @date: 2020-6-19 11:22
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved.
 */
package com.boss.bes.system.manage.pojo.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
*@description:统一的父类，抽取公共的字段
*@author:zyz
*@time:2020/7/3-21:41
*
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

    /**
     *  主键 并且解决前端精度丢失问题
     */
    @Id
    @Column(name = "`id`")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private Boolean status;

    /**
     * 创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createdBy;
    /**
     *  更新时间记录便于追踪
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     *  更新人ID 后续的update更新此字典
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updatedBy;
    /**
     *  当前行的版初始为0 每次数据变动则加1
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
