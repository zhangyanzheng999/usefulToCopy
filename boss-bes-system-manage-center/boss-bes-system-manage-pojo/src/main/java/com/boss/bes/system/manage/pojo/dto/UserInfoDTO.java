package com.boss.bes.system.manage.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:用来给考试题系统的角色用户信息
 * @author:zyz
 * @time:2020/7/20-9:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;
}
