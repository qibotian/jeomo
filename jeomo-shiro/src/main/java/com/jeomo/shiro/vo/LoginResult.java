package com.jeomo.shiro.vo;

import com.jeomo.sys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: qbt
 * @Date: 2019/5/21 22:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class LoginResult {

    /**
     * 登录的用户
     */
    private User user;

    /**
     * 登录的token
     */
    private String token;

}
