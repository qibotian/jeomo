package com.jeomo.mem.api.vo;


import java.io.Serializable;

import com.jeomo.mem.api.enums.MemberRegisterTypeEnum;

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
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 注册的商场Id
     */
    private String mallCode;

    /**
     * 注册类型
     */
    private MemberRegisterTypeEnum registerType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMallCode() {
		return mallCode;
	}

	public void setMallCode(String mallCode) {
		this.mallCode = mallCode;
	}

	public MemberRegisterTypeEnum getRegisterType() {
		return registerType;
	}

	public void setRegisterType(MemberRegisterTypeEnum registerType) {
		this.registerType = registerType;
	}
}
