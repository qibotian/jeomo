package com.jeomo.bonus.controller.web;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.MemberCardFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("bonus")
public class BonusController {

    @Resource
    MemberCardFeignService memberCardFeignService;

    @RequestMapping("card/{code}")
    public MemberCardDto getCardInfo(String code) {
        MemberCardDto card = memberCardFeignService.queryByCode(code);
        return card;
    }

}
