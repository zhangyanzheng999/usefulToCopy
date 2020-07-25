package com.boss.bes.system.manage.pojo.vo;


import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:公司界面的内容
 * @author:zyz
 * @time:2020/7/3-21:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanyVO extends BaseVO {

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
