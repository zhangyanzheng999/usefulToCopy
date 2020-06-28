/**
 * @file:  UserServiceApi.java
 * @author: Administrator
 * @date:   2020-6-19 11:23
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved.
 */
package com.bosssoft.hr.train.springboot.basic.example.api;

import com.bosssoft.hr.train.springboot.basic.example.controller.CommonCRUDApi;
import com.bosssoft.hr.train.springboot.basic.example.data.convention.CommonResponse;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.UserDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.RoleResource;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.UserQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.ResourceVO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.RoleResourceVO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.RoleVO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.UserVO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @class UserServiceApi
 * @classdesc 服务对外的接口保持稳定，调用者可以是API网关也可以其他的系统
 * @author Administrator
 * @date 2020-6-19  11:23
 * @version 1.0.0
 * @see
 * @since
 */
public interface UserServiceApi{
    /**
     *  用户注册调用此接口
     * @param userDTO
     * @return 返回注册成功的用户
     * @see
     * @since
     */

    CommonResponse<UserVO> registry(@RequestBody @Valid UserDTO userDTO);

    /**
     *  注销将调用service的此方法
     * @param userDTO 注销传入的用户信息
     * @return true注销成功 否则失败
     * @see
     * @since
     */
    CommonResponse<Boolean> logout(@RequestBody @Valid UserDTO userDTO);
    /**
     *  对应查询区的多条件查询
     * @param query
     * @return 查询返回用户列表UserVO
     * @see
     * @since
     */
    CommonResponse<List<UserVO>> queryByComboCondition(@RequestBody UserQuery query);


    /**
     *  对应界面上选择单个用户后将选择角色将其分配用户
     * @param roleDTOS
     * @return 带有角色对象的用户
     * @see
     * @since
     */
    CommonResponse<UserVO> assignRole(@RequestBody @Valid List<RoleDTO> roleDTOS);

    /**
     * 对应界面上选择多个用户后将选择角色将其分配用户
     * @param userDTOS
     * @param roleDTOS
     * @return 用户列表其中用户包含角色
     * @see
     * @since
     */
    CommonResponse<List<UserVO>> assignRole(@RequestBody @Valid  List<UserDTO> userDTOS,List<RoleDTO> roleDTOS);


    /*
     * @param: 用户的id 
     * @return:
     * @see
     * @since
     */
    CommonResponse<List<RoleResourceVO>> getRoleResource(@RequestBody @Valid  Long userId);
}
