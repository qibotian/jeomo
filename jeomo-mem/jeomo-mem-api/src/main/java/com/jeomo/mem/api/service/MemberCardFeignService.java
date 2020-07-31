package com.jeomo.mem.api.service;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.fallback.MemberCardFeignServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: qbt
 * @Date: 2020/7/19 21:38
 * @Version 1.0
 */
@FeignClient(value="jeomo-mem", fallbackFactory = MemberCardFeignServiceFallbackFactory.class)
public interface MemberCardFeignService {

    @GetMapping(value = "/api/mem/card/{code}")
    MemberCardDto queryByCode(@PathVariable("code")String code);

    @GetMapping(value = "/api/mem/card/exc/{code}")
    MemberCardDto queryByCodeException(@PathVariable("code")String code);

    @GetMapping(value = "/api/mem/card/overtime/{code}")
    MemberCardDto queryByCodeOvertime(@PathVariable("code")String code);

}
