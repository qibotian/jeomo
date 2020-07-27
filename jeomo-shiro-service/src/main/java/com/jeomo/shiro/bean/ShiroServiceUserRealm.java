package com.jeomo.shiro.bean;

import org.apache.shiro.authc.*;
import org.springframework.stereotype.Component;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:06
 * @Version 1.0
 */
@Component("shiroUserRealm")
public class ShiroServiceUserRealm extends ShiroBaseUserRealm {

    /**
     * 执行认证逻辑
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = (String) token.getUsername();
        System.out.println("************************登录操作：" + username + "*************************");
        if (username == null)
            throw new UnknownAccountException("用户名不能为空");
        User user = MOMERY_USER.get(username);
        if(username == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        //authcInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        //清缓存中的授权信息，保证每次登陆 都可以重新授权。因为AuthorizingRealm会先检查缓存有没有 授权信息，再调用授权方法
        super.clearCachedAuthorizationInfo(authcInfo.getPrincipals());
        return authcInfo;
    }



}
