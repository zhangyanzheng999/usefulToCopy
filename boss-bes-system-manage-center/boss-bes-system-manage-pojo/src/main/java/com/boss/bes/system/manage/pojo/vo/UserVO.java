package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.entity.Role;
import com.boss.bes.system.manage.pojo.vo.common.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @description:用户类的VO
 * @author:zyz
 * @time:2020/7/3-21:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserVO extends BaseVO {
    /**
     * 工号
     */
    private String code;

    /**
     * 密码
     */
    private String password;

    /**
     * 名字
     */
    private String name;

    /**
     * 头像
     */
    private String profilePicture;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 其他联系
     */
    private String other;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户部门
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long departmentId;
    private String departmentName;
    /**
     * 用户职位
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long positionId;


    private String positionName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;

    private String companyName;


    private List<Role> roles;
}
