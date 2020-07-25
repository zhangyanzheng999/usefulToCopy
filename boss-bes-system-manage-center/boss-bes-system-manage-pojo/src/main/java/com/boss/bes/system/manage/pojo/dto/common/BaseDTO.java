package com.boss.bes.system.manage.pojo.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:用来封装公共DTO字段
 * @author:zyz
 * @time:2020/7/3-22:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseDTO implements Serializable {
    /**
     * 主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 版本
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createdBy;
    /**
     * 更新时间记录便于追踪
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人ID 后续的update更新此字典
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updatedBy;
}
