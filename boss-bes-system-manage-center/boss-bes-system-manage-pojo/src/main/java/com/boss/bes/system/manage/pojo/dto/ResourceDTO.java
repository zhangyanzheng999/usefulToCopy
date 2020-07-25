package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-22:16
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResourceDTO extends BaseDTO {
    /**
     * 节点名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 顺序号
     */
    private Integer orderIndex;

    /**
     * 父亲节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    /**
     * 父节点名字
     */
    private String parentName;
    /**
     * URL
     */
    private String url;

    /**
     * 打开图标
     */
    private String openImg;

    /**
     * 关闭图标
     */
    private String closeImg;

    /**
     * 备注
     */
    private String remark;

    /**
     * 资源类型
     */
    private Integer resourceType;

    /**
     * 叶子节点
     */
    private Boolean leaf;
}
