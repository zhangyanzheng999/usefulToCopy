package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.entity.SystemParam;
import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import lombok.*;

import java.util.List;

/**
 * @description:系统参数的资源树
 * @author:zyz
 * @time:2020/7/14-20:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SystemParamTreeVO extends BaseTreeVO {

    List<SystemParam> children;

}
