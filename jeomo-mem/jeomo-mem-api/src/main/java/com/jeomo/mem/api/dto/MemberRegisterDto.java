package com.jeomo.mem.api.dto;

import com.jeomo.mem.api.enums.MemberRegisterTypeEnum;

import java.util.Date;


/**
 * @Author: qbt
 * @Date: 2020/5/8 16:02
 * @Version 1.0
 */
public class MemberRegisterDto {

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
     * 注册时间
     * 默认为当前时间
     */
    private Date openTime = new Date();
    
    /**
     * 注册类型
     */
    private MemberRegisterTypeEnum registerType;

    //***************************** 以下是 getter/setter方法 ********************//

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

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	
}
