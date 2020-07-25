package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:职位类的VO
 * @author:zyz
 * @time:2020/7/3-21:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PositionVO extends BaseVO {
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
