package com.jeomo.shiro.bean;

import com.jeomo.shiro.enums.LoginTypeEnum;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * 开发平台用户登录
 */
@Component
public class OpenApiUserRealm extends ShiroServiceUserRealm{

    public OpenApiUserRealm() {
        super(LoginTypeEnum.OPEN_API);
    }


    /**
     * 执行认证逻辑
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        throw new RuntimeException("暂时不支持的认证方式");
    }
}
