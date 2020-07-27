package com.jeomo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequestMapping("admin")
    @RequiresRoles("ADMIN")
    public String adminResource() {
        return "访问管理员资源。";
    }

    @RequestMapping("user")
    @RequiresRoles("USER")
    public String userResource() {
        return "访问用户资源。";
    }

}
