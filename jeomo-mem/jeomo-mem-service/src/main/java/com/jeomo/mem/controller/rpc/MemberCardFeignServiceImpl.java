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

    @Override
    public MemberCardDto queryByCodeException(String code) {
        throw new RuntimeException("这是一个测试异常");
    }

    @Override
    public MemberCardDto queryByCodeOvertime(String code) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
