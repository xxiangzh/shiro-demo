package com.xzh.shiro.config;

import com.xzh.shiro.entity.User;
import com.xzh.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义Realm用于查询用户的角色和权限信息并保存到权限管理器
 *
 * @author 向振华
 * @date 2020/09/27 17:43
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 权限配置类
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录用户名
        //String userName = (String) principalCollection.getPrimaryPrincipal();
        // 获取权限
        //User userByUserName = userService.getUserByUserName(userName);
        // 封装登录用户的权限信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("一个角色");
        simpleAuthorizationInfo.addStringPermission("z");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证配置类
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取登录用户名
        String userName = authenticationToken.getPrincipal().toString();
        // 获取用户
        User user = userService.getUserByUserName(userName);
        // 这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
        return simpleAuthenticationInfo;
    }
}
