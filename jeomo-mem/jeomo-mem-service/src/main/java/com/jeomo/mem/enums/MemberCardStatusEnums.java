package com.jeomo.mem.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>标题: 会员卡状态模型</p>
 * @author qibotian
 * @time 2020年7月10日 下午2:07:17
 */
public enum MemberCardStatusEnums{
	
	/**
	 * 正常
	 */
	NORMAL(0, "正常"),
	
	/**
	 * 冻结
	 */
	FREEZED(1, "已冻结"),
	
	/**
	 * 注销
	 */
	CLOSED(2, "已注销")
	;
	

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
	
	private MemberCardStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
