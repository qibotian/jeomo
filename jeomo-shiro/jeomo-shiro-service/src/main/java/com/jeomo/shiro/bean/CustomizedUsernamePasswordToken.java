package com.jeomo.shiro.bean;

import com.jeomo.shiro.enums.LoginTypeEnum;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * 自定义一个UsernamePasswordToken,主要声明一个登陆类型，区分不同的登录， 比如C端登录/后台登录等等，然后以不同的Realm进行鉴权
 */
public class CustomizedUsernamePasswordToken extends UsernamePasswordToken implements Serializable {

    public CustomizedUsernamePasswordToken(String username, String password, String loginType) {
        super(username, password);
        this.loginType = LoginTypeEnum.valueOf(loginType);
    }

    /**
     * 登录类型
     */
    private LoginTypeEnum loginType;

    public LoginTypeEnum getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginTypeEnum loginType) {
        this.loginType = loginType;
    }
}
