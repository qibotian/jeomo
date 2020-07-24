package com.jeomo.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @RequestMapping("/hello")
    private String hello() {
        return "hello, 管理员!";
    }
}
