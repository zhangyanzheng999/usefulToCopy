package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

/**
 * @description:用户的树
 * @author:zyz
 * @time:2020/7/15-18:37
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserTreeVO extends BaseTreeVO {
    private List<UserTreeVO> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long departmentId;

}
