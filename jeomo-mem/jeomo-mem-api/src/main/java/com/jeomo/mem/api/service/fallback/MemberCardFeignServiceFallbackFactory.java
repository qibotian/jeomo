package com.jeomo.mem.api.service.fallback;

import com.jeomo.mem.api.dto.MemberCardDto;
import com.jeomo.mem.api.service.MemberCardFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberCardFeignServiceFallbackFactory implements FallbackFactory<MemberCardFeignService> {

    public class MemberCardFeignServiceFallback implements MemberCardFeignService {

        @Override
        public MemberCardDto queryByCode(String code) {
            System.out.println("这是一个正常请求");
            return null;
        }

        @Override
        public MemberCardDto queryByCodeException(String code) {
            System.out.println("这是一个异常请求");
            return null;
        }

        @Override
        public MemberCardDto queryByCodeOvertime(String code) {
            System.out.println("这是一个超时请求");
            return null;
        }
    }


    @Override
    public MemberCardFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new MemberCardFeignServiceFallback();
    }

}
