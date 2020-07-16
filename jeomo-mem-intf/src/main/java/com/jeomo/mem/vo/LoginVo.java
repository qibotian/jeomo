package com.jeomo.mem.vo;

/**
 * @Author: qbt
 * @Date: 2020/2/28 12:24
 * @Version 1.0
 */
public class LoginVo {

    /**
     * 会员手机号
     */
    private String phone;

    /**
     * 会员密码
     */
    private String password;

    /**
     * 购物中心编号
     */
    private String mall;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMall() {
		return mall;
	}

	public void setMall(String mall) {
		this.mall = mall;
	}

}
