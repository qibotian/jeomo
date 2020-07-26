package com.jeomo.shiro.vo;

import com.jeomo.shiro.bean.User;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:16
 * @Version 1.0
 */
public class LoginResultVo {

    /**
     * 登录的用户
     */
    private User user;

    /**
     * 登录的token
     */
    private String token;

    public LoginResultVo(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
