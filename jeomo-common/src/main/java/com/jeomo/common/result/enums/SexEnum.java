package com.jeomo.common.result.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>标题: 性别枚举 </p>
 * @author qibotian
 * @time 2020年7月13日 下午2:18:34
 */
public enum SexEnum {
	/**
	 * 正常
	 */
	MALE(0, "男"),
	
	/**
	 * 冻结
	 */
	FEMALE(1, "女"),
	
	/**
	 * 保密
	 */
	SECRET(2, "已注销");
	

	public int getCode() {
		return this.code;
	}
	
	public String getDesc() {
		return desc;
	}

	@EnumValue
	@JsonValue
	private int code;
	
	private String desc;
	
	private SexEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
