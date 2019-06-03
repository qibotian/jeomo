package com.jeomo.shiro.bean;

import com.jeomo.sys.entity.Role;
import com.jeomo.sys.entity.User;
import com.jeomo.sys.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义Ream
 * @Author: qbt
 * @Date: 2019/5/11 12:25
 * @Version 1.0
 */
@Component
public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // info.addStringPermission("sys:user:create"); 赋予权限  这里不做细致的控制
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Role> roles = user.getRoles();
        roles.forEach((role) -> {
            info.addRole(role.getCode());
        });
        return info;
    }

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName = ((UsernamePasswordToken) token).getUsername();
        User user = userService.findUserByLoginName(loginName);
        user = userService.findUserAllInfoById(user.getId());
        if(user != null) {
            logger.info("用户登录：{}", loginName);
            return new SimpleAuthenticationInfo(user , user.getPassword(), user.getName());
        } else {
            logger.info("用户登录失败：{}", loginName);
            throw new UnknownAccountException();
        }
    }
}