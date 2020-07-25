package com.boss.bes.system.manage.pojo.vo.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:通用树节点VO，不包含children
 * @author:zyz
 * @time:2020/7/9-9:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseTreeVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;
}
