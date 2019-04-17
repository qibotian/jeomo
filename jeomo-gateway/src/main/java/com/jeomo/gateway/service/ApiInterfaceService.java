package com.jeomo.gateway.service;

import com.jeomo.gateway.entity.GatewayRequest;

/**
 *
 * API 服务
 * @Author: qbt
 * @Date: 2019/3/26 20:04
 * @Version 1.0
 */
public interface ApiInterfaceService {

    /**
     * 根据请求获取真正的结果提供者地址
     * @param request
     * @return
     */
    String getServiceProvider(GatewayRequest request);

}
