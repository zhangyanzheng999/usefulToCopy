package com.bosssoft.hr.train.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

/**
 * @description:对应数据字典的entity实体类
 * @author:zyz
 * @time:2020/6/14-20:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDictionary implements Serializable {

    private static final long serialVersionUID = 9155795760256184579L;
    /**
     * 字典Id
     */
    private Integer ddId;
    /**
     * 参数值
     */
    private String argsValue;
    /**
     * 注释
     */
    private String ddNote;
    /**
     * 状态 分为0,1,2吧
     */
    private Integer status;
    /**
     * 组织Id
     */
    private Integer orgId;
    /**
     * 创建者
     */
    private String createdBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 更新者
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 版本
     */
    private String version;

    /**
     * 数据字典类型Id
     */
    private Integer ddTypeId;
    /**
     * 所属数据字典类型
     */
    private DdType ddType;

    @Override
    public String toString() {
        return "DataDictionary{" +
                "ddId=" + ddId +
                ", argsValue='" + argsValue + '\'' +
                ", ddNote='" + ddNote + '\'' +
                ", status=" + status +
                ", orgId=" + orgId +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", version='" + version + '\'' +
                ", ddTypeId=" + ddTypeId +
                ", ddType=" + ddType +
                '}';
    }
}
