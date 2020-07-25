package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
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
public class SystemParamDTO extends BaseDTO {
    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 参数项
     */
    private String name;

    /**
     * 参数值
     */
    private String value;
}
