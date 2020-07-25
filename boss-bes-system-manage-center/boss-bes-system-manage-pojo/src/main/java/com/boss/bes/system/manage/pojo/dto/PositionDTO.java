package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


/**
 * @description:
 * @author:zyz
 * @time:2020/7/3-22:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PositionDTO extends BaseDTO {
    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位编号
     */
    private String code;

    /**
     * 备注
     */
    private String remark;

    /**
     * 公司ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    private String companyName;
}
