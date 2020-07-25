package com.boss.bes.system.manage.pojo.dto;


import com.boss.bes.system.manage.pojo.vo.ResourceTreeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:资源角色的DTO，前端返回的是ResourceTreeVO的集合
 * @author:zyz
 * @time:2020/7/17-12:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceRoleDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long resourceId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;


    private List<ResourceTreeVO> resources;
}
