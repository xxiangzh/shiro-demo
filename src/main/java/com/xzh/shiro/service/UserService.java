package com.xzh.shiro.service;

import com.xzh.shiro.entity.User;

/**
 * 用户服务
 *
 * @author 向振华
 * @date 2020/09/28 10:22
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
}