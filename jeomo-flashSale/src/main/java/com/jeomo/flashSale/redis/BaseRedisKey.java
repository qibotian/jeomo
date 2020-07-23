package com.jeomo.flashSale.redis;

import java.util.concurrent.TimeUnit;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public TimeUnit getExpireTimeUnit() {
		return expireTimeUnit;
	}

	public void setExpireTimeUnit(TimeUnit expireTimeUnit) {
		this.expireTimeUnit = expireTimeUnit;
	}
}
