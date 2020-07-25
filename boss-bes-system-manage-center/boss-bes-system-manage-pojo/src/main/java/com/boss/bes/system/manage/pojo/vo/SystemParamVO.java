package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import lombok.*;

/**
 * @description:系统参数的VO
 * @author:zyz
 * @time:2020/7/3-21:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SystemParamVO extends BaseVO {
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
