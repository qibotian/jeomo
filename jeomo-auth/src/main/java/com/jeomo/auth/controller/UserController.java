package com.jeomo.auth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/hello")
    private String hello() {
        return "hello, 用户!";
    }


    @RequestMapping("/info")
    private String info() {
        boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        if(isAuthenticated) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "已认证， 你的身份信息是： " + user.getUsername();
        }
        return "你的身份信息是： " + SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
