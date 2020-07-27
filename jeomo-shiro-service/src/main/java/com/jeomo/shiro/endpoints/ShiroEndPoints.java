package com.jeomo.shiro.endpoints;

import com.jeomo.shiro.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
public class ShiroEndPoints {

    @Autowired
    public HashedCredentialsMatcher credentialsMatcher;

    /**
     * 提示登录信息
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "请登录";
    }

    /**
     * 自定义登录过程
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/doLogin")
    public User doLogin(@RequestParam String username, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        User user = (User)(subject.getPrincipal());
        return user;
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "您已退出登录，欢迎再来! ε=(´ο｀*)))";
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/success")
    public String authSuccess() {
        Subject subject = SecurityUtils.getSubject();
        return "(*´▽｀)ノノ，认证成功！欢迎您：" + subject;
    }

    /**
     * 认证失败
     * @return
     */
    @RequestMapping("/error")
    public String authError() {
        Subject subject = SecurityUtils.getSubject();
        return "ε=(´ο｀*)))，认证失败！";
    }


    /**
     * @return
     */
    @RequestMapping("/user/info")
    public User user() {
        User subject = (User) SecurityUtils.getSubject().getPrincipal();
        return subject;
    }



}
