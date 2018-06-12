package com.csc.learn.swagger.controller;

import com.csc.learn.swagger.data.User;
import com.csc.learn.swagger.service.UserService;
import com.csc.learn.swagger.support.ResJson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
@Api(description = "用户接口")
@RestController(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "queryUser/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", defaultValue = "1")
    public String queryUser(int userId) {
        return ResJson.success(userService.queryUserById(userId));
    }

    @ResponseBody
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "int", defaultValue = "george"),
            @ApiImplicitParam(name = "sex", value = "性别:1表示男,0表示女", required = true, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "int", defaultValue = "13176546476"),
    })
    public String saveUser(String userName, int sex, String phone) {
        User user = new User(userName, sex, phone);
        return ResJson.success(userService.saveUser(user));
    }
}
