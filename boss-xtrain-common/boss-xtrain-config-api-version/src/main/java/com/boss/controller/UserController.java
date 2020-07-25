package com.boss.controller;

import com.boss.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author : gln
 * @version 1.0
 * @description :
 * @date : 2020-06-30 22:17
 **/
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    @GetMapping("/swaggertest")
    @ApiOperation(value = "测试Swagger")
    public String hello(){
        return "hello SpringBoot-swagger";
    }
    @PostMapping("/")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    }
    )
    public String addUser(String username, @RequestParam(required = true) String address) {
        return "test addUser";
    }
    @ApiOperation(value = "提交订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId1", value = "订单Id", required = true), // orderId1
            @ApiImplicitParam(name = "orderId2", value = "订单Id2", required = true, dataType = "String", paramType = "path"), // orderId2
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User") // user
    })
    @RequestMapping(value = "add/order/{orderId2}", method = RequestMethod.POST)
    public String addOrder(
            @RequestParam String orderId1,
            @PathVariable String orderId2,
            @RequestBody User user) {
        return "add/order";
    }

    @GetMapping("/")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    public User getUserById(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }
    @PutMapping("/{id}")
    @ApiOperation("根据id更新用户的接口")
    public User updateUserById(@RequestBody User user) {
        return user;
    }
}

