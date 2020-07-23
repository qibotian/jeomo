package com.jeomo.shiro.vo;

import com.jeomo.sys.entity.User;


/**
 * @Author: qbt
 * @Date: 2019/5/21 22:44
 * @Version 1.0
 */

public class LoginResult {

    /**
     * 登录的用户
     */
    private User user;

    /**
     * 登录的token
     */
    private String token;

    public LoginResult(User user, String token) {
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
