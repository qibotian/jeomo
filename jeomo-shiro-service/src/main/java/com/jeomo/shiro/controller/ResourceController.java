package com.jeomo.shiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/7/26 22:19
 * @Version 1.0
 */
@RestController
@RequestMapping("resource")
public class ResourceController {

    @RequestMapping("admin")
    public String adminResource() {
        return "访问管理员资源。";
    }

    @RequestMapping("user")
    public String userResource() {
        return "访问用户资源。";
    }

}
