package com.jeomo.mem.intf.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeomo.mem.intf.fallback.MemberFeignServiceFallback;

/**
 * @Author: qbt
 * @Date: 2020/7/19 21:38
 * @Version 1.0
 */
@FeignClient(value="jeomo-mem")
public interface MemberFeignService {

    @GetMapping("/mem/test/{code}")
    public String test(@PathVariable(name="code", required=true) String code);

}
