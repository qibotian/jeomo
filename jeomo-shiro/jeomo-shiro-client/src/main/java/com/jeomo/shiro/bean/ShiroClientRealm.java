package com.jeomo.shiro.bean;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * @Author: qbt
 * @Date: 2020/7/27 10:38
 * @Version 1.0
 */
@Component("shiroUserRealm")
public class ShiroClientRealm extends ShiroBaseUserRealm {

    /**
     * 客户端没有认证，所有认证都交给服务器端
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
