package com.jeomo.mem.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Author: qbt
 * @Date: 2020/5/8 16:10
 * @Version 1.0
 */
public enum MemberRegisterTypeEnum {

    MEMBER_CENTER(1, "会员中心注册"),
    MINI_PROGRAM(2, "小程序注册"),
    OFFICIAL_ACCOUNT(3, "公众号注册"),;
	
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
	
	private MemberRegisterTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}

