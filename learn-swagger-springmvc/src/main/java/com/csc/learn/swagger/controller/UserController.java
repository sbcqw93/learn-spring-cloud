package com.csc.learn.swagger.controller;

import com.csc.learn.swagger.data.User;
import com.csc.learn.swagger.service.UserService;
import com.csc.learn.swagger.support.ResJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/12 0012.
 * paramType 参数类型 body、path、query、header、form中的一种
 */
@Api(description = "用户接口")
@Controller(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "queryUser/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path", defaultValue = "100")
    public String queryUser(@PathVariable Integer userId) {
        return ResJson.success(userService.queryUserById(userId));
    }

    @ResponseBody
    @RequestMapping(value = "saveUserByBody", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User", paramType = "body")
    public String saveUserByBody(@RequestBody User user) {
        return ResJson.success(userService.saveUser(user));
    }

    @ResponseBody
    @RequestMapping(value = "saveUserByFields", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "string", paramType = "query", defaultValue = "george"),
            @ApiImplicitParam(name = "sex", value = "性别:1表示男,0表示女", required = true, dataType = "int", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "string", paramType = "query", defaultValue = "13176546476")
    })
    public String saveUserByFields(@RequestParam String userName, @RequestParam int sex, @RequestParam String phone) {
        User user = new User(userName, sex, phone);
        return ResJson.success(userService.saveUser(user));
    }
}
