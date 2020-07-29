package com.jeomo.shiro.bean;

import com.jeomo.common.util.StringUtils;
import com.jeomo.shiro.dto.UserDto;
import com.jeomo.shiro.enums.LoginTypeEnum;
import com.jeomo.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 管理用户登录
 */
@Component
public class ManageUserRealm extends ShiroServiceUserRealm{

    @Autowired
    private IUserService userService;


    public ManageUserRealm() {
        super(LoginTypeEnum.MANAGE);
    }

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
        if (StringUtils.isEmpty(username))
            throw new UnknownAccountException("用户名不能为空");
        UserDto userDto = userService.queryAllInfoByUsername(username);
        //User user = MOMERY_USER.get(username);
        if(userDto == null) {
            throw new UnknownAccountException("无此用户");
        }
        SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userDto, userDto.getPassword(), this.getName());
        //authcInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        //清缓存中的授权信息，保证每次登陆 都可以重新授权。因为AuthorizingRealm会先检查缓存有没有 授权信息，再调用授权方法
        super.clearCachedAuthorizationInfo(authcInfo.getPrincipals());
        return authcInfo;
    }
}
