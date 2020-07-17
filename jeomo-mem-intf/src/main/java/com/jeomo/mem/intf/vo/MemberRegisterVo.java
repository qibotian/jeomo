package com.jeomo.mem.intf.vo;


import java.io.Serializable;

import com.jeomo.mem.intf.enums.MemberRegisterTypeEnum;

import lombok.Getter;

/**
 * @Author: qbt
 * @Date: 2020/5/8 16:02
 * @Version 1.0
 */
public class MemberRegisterVo implements Serializable{

    /**  */
	private static final long serialVersionUID = 1L;

	/**
     * 姓名
     */
    @Getter
    private String name;

    /**
     * 手机号
     */
    @Getter
    private String phone;

    /**
     * 注册的商场Id
     */
    @Getter
    private String mallCode;

    /**
     * 注册类型
     */
    @Getter
    private MemberRegisterTypeEnum registerType;

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}

	public void setRegisterType(MemberRegisterTypeEnum registerType) {
		this.registerType = registerType;
	}

}
