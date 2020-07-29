package com.jeomo.mem.controller.rpc;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.MemberCardFeignService;
import com.jeomo.mem.service.IMemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberCardFeignServiceImpl implements MemberCardFeignService {

    @Autowired
    IMemberCardService memberCardService;

    @Override
    public MemberCardDto queryByCode(String code) {
        return memberCardService.queryByCode(code);
    }

}
