package com.boss.bes.system.manage.pojo.dto;

import com.boss.bes.system.manage.pojo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:用户角色对应的DTO
 * @author:zyz
 * @time:2020/7/16-19:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;
    /**
     * 公司Id，根据这个去清空
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    private List<User> users;
}
