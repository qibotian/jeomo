package com.jeomo.flashSale.redis;

import lombok.Data;

@Data
public class BaseRedisKeyPrefix {
	
	/**
	 * 前缀
	 */
	private String prefix;
	
	/**
	 * 过期时间
	 */
	private int expire;
	
	
	
}
