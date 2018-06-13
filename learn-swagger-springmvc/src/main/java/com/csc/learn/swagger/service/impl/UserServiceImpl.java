package com.csc.learn.swagger.service.impl;

import com.csc.learn.swagger.data.User;
import com.csc.learn.swagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User queryUserById(int userId) {
        LOG.info("queryUserById 成功, userId={}", userId);
        User user = new User("默认", 1, "默认");
        user.setId(userId);
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        LOG.info("saveUser 成功, user={}", user);
        return true;
    }
}
