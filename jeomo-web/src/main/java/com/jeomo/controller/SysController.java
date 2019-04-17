package com.jeomo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: qbt
 * @Date: 2019/3/21 20:49
 * @Version 1.0
 */
@Controller
@RequestMapping("sys")
public class SysController {

    @RequestMapping("")
    public  String index() {
        System.out.println("index");
        return "index";
    }


}
