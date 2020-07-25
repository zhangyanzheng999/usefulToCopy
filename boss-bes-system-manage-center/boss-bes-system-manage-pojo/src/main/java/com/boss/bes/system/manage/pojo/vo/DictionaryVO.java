package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * @description:字典类的VO
 * @author:zyz
 * @time:2020/7/14-16:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DictionaryVO extends BaseVO {
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
