package com.jeomo.shiro.bean;

import com.jeomo.shiro.enums.LoginTypeEnum;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:06
 * @Version 1.0
 */
public abstract class ShiroServiceUserRealm extends ShiroBaseUserRealm {

    private LoginTypeEnum loginType;

    public ShiroServiceUserRealm(LoginTypeEnum loginType) {
        this.loginType = loginType;
    }

    /**
     * 获取登录方式
     * @return
     */
    public LoginTypeEnum getLoginType() {
        return loginType;
    }
}
