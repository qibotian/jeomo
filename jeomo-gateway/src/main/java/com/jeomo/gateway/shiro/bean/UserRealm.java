package com.jeomo.gateway.shiro.bean;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Ream
 * @Author: qbt
 * @Date: 2019/5/11 12:25
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final Set<String> tomRoleNameSet = new HashSet<>();
    private static final Set<String> tomPermissionNameSet = new HashSet<>();
    private static final Set<String> jerryRoleNameSet = new HashSet<>();
    private static final Set<String> jerryPermissionNameSet = new HashSet<>();

    static {
        tomRoleNameSet.add("admin");
        jerryRoleNameSet.add("user");
        tomPermissionNameSet.add("resource:insert");
        tomPermissionNameSet.add("resource:update");
        tomPermissionNameSet.add("resource:delete");
        tomPermissionNameSet.add("resource:query");
        jerryPermissionNameSet.add("resource:query");
    }

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        if (username.equals("tom")) {
            info.addRoles(tomRoleNameSet);
            info.addStringPermissions(tomPermissionNameSet);
        } else if (username.equals("jerry")) {
            info.addRoles(jerryRoleNameSet);
            info.addStringPermissions(jerryPermissionNameSet);
        }
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
        String username = (String) token.getPrincipal();
        if (username == null)
            throw new UnknownAccountException("用户名不能为空");
        SimpleAuthenticationInfo info = null;
        if (username.equals("tom"))
            return new SimpleAuthenticationInfo("tom", "123", UserRealm.class.getName());
        else if (username.equals("jerry"))
            return new SimpleAuthenticationInfo("jerry", "123", UserRealm.class.getName());
        else
            return null;
    }
}
