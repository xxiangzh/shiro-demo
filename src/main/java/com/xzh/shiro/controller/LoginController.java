package com.xzh.shiro.controller;

import com.xzh.shiro.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author 向振华
 * @date 2020/09/27 17:33
 */
@Api(tags = "登录")
@RestController
@RequestMapping
public class LoginController {

    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 获取subject
        Subject subject = SecurityUtils.getSubject();
        // 封装用户账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        // 执行登录方法
        subject.login(token);
        return "success";
    }
}
