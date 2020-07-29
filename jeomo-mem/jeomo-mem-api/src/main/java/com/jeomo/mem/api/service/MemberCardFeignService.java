package com.jeomo.mem.api.service;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.fallback.MemberCardFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: qbt
 * @Date: 2020/7/19 21:38
 * @Version 1.0
 */
@FeignClient(value="jeomo-mem", fallback= MemberCardFeignServiceFallback.class)
public interface MemberCardFeignService {

    @PostMapping(value = "/api/mem/card/queryByCode/{code}")
    MemberCardDto queryByCode(@PathVariable("code")String code);


}
