package com.csc.learn.swagger.service;

import com.csc.learn.swagger.data.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Generated;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
public interface UserService {
    public User queryUserById(int userId);
    public boolean saveUser(User user);
}
