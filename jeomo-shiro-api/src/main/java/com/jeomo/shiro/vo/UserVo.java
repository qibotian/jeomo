package com.jeomo.shiro.vo;

import java.beans.Transient;
import java.io.Serializable;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:17
 * @Version 1.0
 */
public class UserVo implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * redis-shiro需要一个序列化的id
     * @return
     */
    @Transient
    public String getAuthCacheKey() {
        return this.username;
    }

}
