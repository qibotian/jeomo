package com.jeomo.flashSale.redis;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class BaseRedisKey {

	/**
	 * 前缀
	 */
	private String key;

	/**
	 * 过期时间
	 */
	private Long expire;


	private TimeUnit expireTimeUnit;

	public BaseRedisKey(String key, Long expire, TimeUnit expireTimeUnit) {
		super();
		this.expire = expire;
		this.key = key;
		this.expireTimeUnit = expireTimeUnit;
	}

}
