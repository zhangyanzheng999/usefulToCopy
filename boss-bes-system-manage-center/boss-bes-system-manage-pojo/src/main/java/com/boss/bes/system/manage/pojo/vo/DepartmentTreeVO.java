package com.boss.bes.system.manage.pojo.vo;


import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

/**
 * @description:部门页面的树节点
 * @author:zyz
 * @time:2020/7/10-14:09
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentTreeVO extends BaseTreeVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long organizationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
    /**
     * 部门父节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private List<DepartmentTreeVO> children;
}
