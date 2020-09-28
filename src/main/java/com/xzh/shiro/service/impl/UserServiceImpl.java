package com.xzh.shiro.service.impl;

import com.xzh.shiro.entity.User;
import com.xzh.shiro.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author 向振华
 * @date 2020/09/28 10:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUserName(String userName) {
        return new User(1L, "xzh", "123456");
    }
}
