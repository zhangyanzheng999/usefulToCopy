package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
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
public class OrganizationDTO extends BaseDTO {
    /**
     * 机构名
     */
    private String name;

    /**
     * 机构代码
     */
    private String code;

    /**
     * 负责人
     */
    private String master;

    /**
     * 电话
     */
    private String tel;

    /**
     * 地址
     */
    private String address;
}
