package com.jeomo.bonus.controller;

import com.jeomo.mem.intf.feign.MemberFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: qbt
 * @Date: 2020/7/19 20:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/bonus")
public class BonusController {

    final String MEM_SERVICE_NAME = "http://JEOMO-MEM";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private MemberFeignService memberFeignService;

    @GetMapping("test/{code}")
    public String test(@PathVariable(name="code", required=true) String code) {
        return  memberFeignService.test(code);
    }

    @GetMapping("/test2/{code}")
    public String test2(@PathVariable(name="code", required=true) String code) {
            return  restTemplate.getForObject(MEM_SERVICE_NAME+"/mem/test/"+code, String.class);
    }

}
