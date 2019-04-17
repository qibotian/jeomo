package com.jeomo.gateway.controller;

import com.jeomo.gateway.entity.GatewayRequest;
import com.jeomo.gateway.service.ApiInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2019/4/2 20:36
 * @Version 1.0
 */
@RestController
@RequestMapping("")
public class GatewayController {

    @Autowired
    ApiInterfaceService apiInterfaceService;

    @RequestMapping("/api")
    public  String api() {
        GatewayRequest request = new GatewayRequest("");
        request.setPath("mem");
        apiInterfaceService.getServiceProvider(request);
        return "hello gateway";
    }


}
