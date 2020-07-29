package com.jeomo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:19
 * @Version 1.0
 */
@RestController
@RequestMapping("res")
public class ResController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("admin")
    @RequiresRoles("admin")
    public String adminResource() {
        return "访问管理员资源。 访问端口：" + port;
    }

    @RequestMapping("user")
    @RequiresRoles("user")
    public String userResource() {
        return "访问用户资源。。 访问端口：" + port;
    }

}
