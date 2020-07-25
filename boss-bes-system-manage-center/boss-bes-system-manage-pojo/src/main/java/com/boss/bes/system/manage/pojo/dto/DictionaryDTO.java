package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;



/**
 * @description:
 * @author:zyz
 * @time:2020/7/14-16:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DictionaryDTO extends BaseDTO {
    /**
     * 字典名
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;

    /**
     * 字典类型
     */
    private String category;

    /**
     * 字典值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 机构ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

}
