package com.bosssoft.hr.train.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:数据字典类型
 * @author:zyz
 * @time:2020/6/15-20:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DdType implements Serializable {
    private static final long serialVersionUID = -6016734440547141890L;
    /**
     * 类型id
     */
    private Integer ddTypeId;
    /**
     * 类型名称
     */
    private String ddTypeName;
    /**
     * 类型注释
     */
    private String ddTypeNote;


    @Override
    public String toString() {
        return "DdType{" +
                "ddTypeId=" + ddTypeId +
                ", ddTypeName='" + ddTypeName + '\'' +
                ", ddTypeNote='" + ddTypeNote + '\'' +
                '}';
    }
}
