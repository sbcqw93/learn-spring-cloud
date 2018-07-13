package com.csc.learn.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csc.learn.swagger.data.User;
import com.csc.learn.swagger.service.UserService;
import com.csc.learn.swagger.support.RespBody;
import com.csc.learn.swagger.support.RestRespBody;
import com.csc.learn.swagger.support.RestRespBodyUtils;

/**
 * Created by Lihuan on 2018/6/12 0012. paramType 参数类型
 * body、path、query、header、form中的一种
 */
@RestController
@RequestMapping(value = "user")
@Api("用户接口")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "queryUser/{userId}", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path", defaultValue = "100")
	public String queryUser(@PathVariable Integer userId) {
		return RespBody.success("查询成功", userService.queryUserById(userId));
	}

	@ResponseBody
	@RequestMapping(value = "queryUser2/{userId}", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path", defaultValue = "100")
	public RestRespBody<User> queryUser2(@PathVariable Integer userId) {
		// return RestRespBodyUtils.failure("查询失败");
		// return RestRespBodyUtils.failure("10", "查询失败");
		// return RestRespBodyUtils.failure("查询失败", userService.queryUserById(userId));
		// return RestRespBodyUtils.failure("10", "查询失败", userService.queryUserById(userId));

		// return RestRespBodyUtils.success();
		// return RestRespBodyUtils.success("查询成功");
		// return RestRespBodyUtils.success("10", "查询成功");
		return RestRespBodyUtils.success("查询成功", userService.queryUserById(userId));
		// return RestRespBodyUtils.success("10", "查询成功", userService.queryUserById(userId));
	}

	@ResponseBody
	@RequestMapping(value = "saveUserByBody", method = RequestMethod.POST)
	@ApiOperation(value = "保存用户信息", notes = "保存用户信息")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User", paramType = "body")
	public String saveUserByBody(@RequestBody User user) {
		return RespBody.success("保存成功", userService.saveUser(user));
	}

	@ResponseBody
	@RequestMapping(value = "saveUserByFields", method = RequestMethod.POST)
	@ApiOperation(value = "保存用户信息", notes = "保存用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "string", paramType = "query", defaultValue = "george"),
			@ApiImplicitParam(name = "sex", value = "性别:1表示男,0表示女", required = true, dataType = "int", paramType = "query", defaultValue = "1"),
			@ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "string", paramType = "query", defaultValue = "13176546476") })
	public String saveUserByFields(@RequestParam String userName, @RequestParam int sex, @RequestParam String phone) {
		userName = userName.trim();
		User user = new User(userName, sex, phone);
		return RespBody.success("保存成功", userService.saveUser(user));
	}
}
