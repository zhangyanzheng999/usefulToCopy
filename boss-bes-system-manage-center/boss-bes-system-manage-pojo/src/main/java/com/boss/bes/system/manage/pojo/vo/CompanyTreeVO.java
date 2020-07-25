package com.boss.bes.system.manage.pojo.vo;


import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

/**
 * @description:部门涉及到的树节点,用来展示给前端
 * @author:zyz
 * @time:2020/7/10-10:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanyTreeVO extends BaseTreeVO {
    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;
    private List<CompanyTreeVO> children;

}
