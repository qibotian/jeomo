package com.jeomo.bonus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: qbt
 * @Date: 2020/7/19 20:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/bonus")
//@DefaultProperties(defaultFallback="testFallback3")
public class BonusController {

    final String MEM_SERVICE_NAME = "http://jeomo-mem";

    @Autowired
    private RestTemplate restTemplate;
//
//    @Resource
//    private MemberFeignService memberFeignService;
//
//    @GetMapping("test/{code}")
//    @HystrixCommand(fallbackMethod = "testFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
//        })
//    public String test(@PathVariable(name="code", required=true) String code) {
//        return  memberFeignService.test(code);
//    }
//
//    public String testFallback() throws InterruptedException {
//        return "服务调用超时啦， 请稍后再试，o(╥﹏╥)o";
//    }
//
//
//    @GetMapping("test3/{code}")
//    @HystrixCommand
//    public String test3(@PathVariable(name="code", required=true) String code) {
//        return  memberFeignService.test(code);
//    }
//
//    public String testFallback3() throws InterruptedException {
//        return "服务调用超时啦， 请稍后再试，o(╥﹏╥)o";
//    }

//    @GetMapping("/test2/{code}")
//    public String test2(@PathVariable(name="code", required=true) String code) {
//            return  restTemplate.getForObject(MEM_SERVICE_NAME+"/mem/test/"+code, String.class);
//    }

//	  @GetMapping("test4/{code}")
//	  public String test4(@PathVariable(name="code", required=true) String code) {
//	      return  memberFeignService.test(code);
//	  }

}
