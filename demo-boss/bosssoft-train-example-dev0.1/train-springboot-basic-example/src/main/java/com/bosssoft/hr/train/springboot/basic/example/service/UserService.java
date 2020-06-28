/**
 * @file:  UserService.java
 * @author: Administrator    
 * @date:   2020-6-19 11:19
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.bosssoft.hr.train.springboot.basic.example.service;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.UserDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.BaseQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.UserVO;
import java.util.List;

/**
 * @class UserService
 * @classdesc 依据需要多少业务动作需要在UserService做就决定UserService需要定义多少

 * @author Administrator
 * @date 2020-6-19  10:56
 * @version 1.0.0
 * @see
 * @since
 */
public interface UserService<T extends UserDTO,V extends UserVO,Q extends  BaseQuery> {
    /**
     *  用户注册调用此接口
     * @param userDTO
     * @return 返回注册成功的用户
     * @see
     * @since
     */
    UserDTO registry(T userDTO);

    /**
     *  注销将调用service的此方法
     * @param userDTO 注销传入的用户信息
     * @return true注销成功 否则失败
     * @see
     * @since
     */
    boolean logout(T userDTO);

    /**
     *  对应查询区的多条件查询
     * @param query
     * @return 查询返回用户列表UserVO
     * @see
     * @since
     */
    List<V> queryByComboCondition(Q query);

   /**
    * 对应界面上选择单个用户后将选择角色将其分配用户
    * @param roleDTOS
    * @return 带有角色对象的用户
    * @see
    * @since
    */
    T assignRole(List<RoleDTO> roleDTOS);

    /**
     * 对应界面上选择多个用户后将选择角色将其分配用户
     * @param userDTOS
     * @param roleDTOS
     * @see
     * @since
     */
    List<T> assignRoleWith(List<UserDTO> userDTOS,List<RoleDTO> roleDTOS);

}
