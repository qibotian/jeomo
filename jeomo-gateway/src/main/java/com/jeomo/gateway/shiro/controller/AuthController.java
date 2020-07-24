package com.jeomo.gateway.shiro.controller;

import com.jeomo.common.result.annotation.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qbt
 * @Date: 2019/5/11 14:43
 * @Version 1.0
 */
@RestController
@ResponseResult
@RequestMapping("/")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping("/login")
    public String login() {
        return "登录页面";
    }

    @RequestMapping("/auth/success")
    public String authSuccess() {
        Subject subject = SecurityUtils.getSubject();
        //User user = (User)(subject.getPrincipal());
        return "(*´▽｀)ノノ，认证成功！欢迎您：" + subject.getPrincipal();
    }

    @RequestMapping("/auth/error")
    public String authError() {
        Subject subject = SecurityUtils.getSubject();
        return "ε=(´ο｀*)))，认证失败！";
    }


    @RequestMapping("/auth/login")
    public String authLogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        logger.info("用户登录，username:{}", username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        logger.info("用户登录成功，username:{}", subject.getPrincipal());
//        User user = (User)(subject.getPrincipal());
        //User user = new User();
        // user.setNickname(username);
        return subject.getPrincipal().toString();
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
