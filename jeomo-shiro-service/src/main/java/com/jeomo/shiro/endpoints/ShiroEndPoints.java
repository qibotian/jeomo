package com.jeomo.shiro.endpoints;

import com.jeomo.shiro.bean.User;
import com.jeomo.shiro.vo.LoginResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:12
 * @Version 1.0
 */
@RestController
public class ShiroEndPoints {

    /**
     * 提示登录信息
     * @return
     */
    @RequestMapping("/login")
    public void login() {
        throw new AuthenticationException("请登录");
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/auth/success")
    public String authSuccess() {
        Subject subject = SecurityUtils.getSubject();
        return "(*´▽｀)ノノ，认证成功！欢迎您：" + subject;
    }

    /**
     * 认证失败
     * @return
     */
    @RequestMapping("/auth/error")
    public String authError() {
        Subject subject = SecurityUtils.getSubject();
        return "ε=(´ο｀*)))，认证失败！";
    }

    /**
     * 自定义登录过程
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/auth/login")
    public LoginResultVo authLogin(@RequestParam String username, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
//        User user = (User)(subject.getPrincipal());
        User user = new User();
        return new LoginResultVo(user, subject.getSession().getId().toString());
    }

    /**
     * @return
     */
    @RequestMapping("/user/info")
    public String user() {
        Subject subject = SecurityUtils.getSubject();
        return subject.getPrincipal().toString();
    }

    @RequestMapping(value = "/auth/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "您已退出登录，欢迎再来! ε=(´ο｀*)))";
    }

}
