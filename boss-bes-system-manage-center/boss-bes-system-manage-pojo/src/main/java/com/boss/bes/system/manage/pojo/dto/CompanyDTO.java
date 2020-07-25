package com.boss.bes.system.manage.pojo.dto;


import com.boss.bes.system.manage.pojo.dto.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:前端传给后端的信息
 * @author:zyz
 * @time:2020/7/3-22:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanyDTO extends BaseDTO {
    /**
     * 公司名
     */
    private String name;

    /**
     * 公司编号
     */
    private String code;

    /**
     * 助记码
     */
    private String mnemonicCode;

    /**
     * 法人
     */
    private String master;

    /**
     * 税号
     */
    private String tax;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电话
     */
    private String telephone;

    /**
     * address
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 网址
     */
    private String website;

    /**
     * 组织机构ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    private String organizationName;
}
