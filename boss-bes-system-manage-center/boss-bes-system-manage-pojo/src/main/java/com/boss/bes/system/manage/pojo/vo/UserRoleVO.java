package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:用户角色表的VO
 * @author:zyz
 * @time:2020/7/16-19:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;


    private List<User> users;
}
