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

	public BaseRedisKeyPrefix(String prefix, int expire) {
		super();
		this.expire = expire;
		this.prefix = prefix;
	}

}
