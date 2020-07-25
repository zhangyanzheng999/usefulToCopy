package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.entity.Resource;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:资源角色的VO
 * @author:zyz
 * @time:2020/7/17-12:08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResourceRoleVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long resourceId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;


    private List<Resource> resources;

}
