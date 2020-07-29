package com.jeomo.mem.api.service.fallback;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.MemberCardFeignService;
import org.springframework.stereotype.Component;

@Component
public class MemberCardFeignServiceFallback implements MemberCardFeignService {

    @Override
    public MemberCardDto queryByCode(String code) {
        return null;
    }
}
