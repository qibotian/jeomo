package com.jeomo.mem.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jeomo.mem.entity.Member;
import com.jeomo.mem.service.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/mem")
public class MemController {

    @Reference(version="${mem.service.version}")
    IMemberService memberService;


    @RequestMapping(value = "hi")
    @ResponseBody
    public String sayHi() {
        memberService.sayHi();
        return "hello dubbo";
    }


    @RequestMapping("/{id}")
    @ResponseBody
    public Member get(@PathVariable Long id) {
        return  memberService.getById(id);
    }


    @RequestMapping("/t/{id}")
    @ResponseBody
    public Member tGet(@PathVariable Long id) {
        return  memberService.testGetById(id);
    }

}
