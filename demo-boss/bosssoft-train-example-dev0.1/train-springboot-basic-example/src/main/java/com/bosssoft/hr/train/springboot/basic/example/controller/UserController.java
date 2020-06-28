/**
 * @file:  UserController.java
 * @author: Administrator
 * @date:   2020-6-19 11:20
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved.
 */
package com.bosssoft.hr.train.springboot.basic.example.controller;

import com.bosssoft.hr.train.springboot.basic.example.api.UserServiceApi;
import com.bosssoft.hr.train.springboot.basic.example.dao.mapper.UserMapper;
import com.bosssoft.hr.train.springboot.basic.example.data.convention.CommonResponse;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.RoleDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.dto.UserDTO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.entity.User;
import com.bosssoft.hr.train.springboot.basic.example.pojo.query.UserQuery;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.RoleResourceVO;
import com.bosssoft.hr.train.springboot.basic.example.pojo.vo.UserVO;
import com.bosssoft.hr.train.springboot.basic.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @class UserController
 * @classdesc
 * @author Administrator
 * @date 2020-6-26  22:26
 * @version 1.0.0
 * @see 
 * @since 
 */
@RestController
public  class UserController extends BaseCRUDController<UserDTO,User,UserQuery,UserMapper,UserVO> implements UserServiceApi {
    @Autowired
    public  UserController(UserServiceImpl userService){
            this.service=userService;
    }
    @Override
    public CommonResponse<UserVO> registry(@Valid UserDTO userDTO) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> logout(@Valid UserDTO userDTO) {
        return null;
    }

    @Override
    public CommonResponse<List<UserVO>> queryByComboCondition(UserQuery query) {
        return null;
    }
    @Override
    public CommonResponse<UserVO> assignRole(@Valid List<RoleDTO> roleDTOS) {
        return null;
    }

    @Override
    public CommonResponse<List<UserVO>> assignRole(@Valid List<UserDTO> userDTOS, List<RoleDTO> roleDTOS) {
        return null;
    }

    @Override
    public CommonResponse<List<RoleResourceVO>> getRoleResource(@Valid Long userId) {
        return null;
    }

    @Override
    protected UserVO doObjectTransf(Object returnDto) {

        return null;
    }

    @Override
    public CommonResponse<Integer> create(@Valid UserDTO dtoParam) {
        return super.create(dtoParam);
    }

    @Override
    public CommonResponse<UserVO> query(@Valid UserQuery queryParam) {
        return super.query(queryParam);
    }

    @Override
    public CommonResponse update(@Valid UserDTO dtoParam) {
        return super.update(dtoParam);
    }

    @Override
    public CommonResponse delete(@Valid UserDTO dtoParam) {
        return super.delete(dtoParam);
    }
}
