package com.jeomo.mem.intf.fallback;

import org.springframework.stereotype.Component;

import com.jeomo.mem.intf.feign.MemberFeignService;

@Component
public class MemberFeignServiceFallback implements MemberFeignService {

	@Override
	public String test(String code) {
		return "---------fallback---------fallback---------";
	}

}
