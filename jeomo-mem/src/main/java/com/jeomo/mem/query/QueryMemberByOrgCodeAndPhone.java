package com.jeomo.mem.query;

/**
 * <p>标题: 根据组织号和手机号查询会员信息</p>
 * @author qibotian
 * @time 2020年7月16日 下午3:28:56
 */
public class QueryMemberByOrgCodeAndPhone {
	
	private String orgCode;
	
	private String phone;
	
	public QueryMemberByOrgCodeAndPhone(String orgCode, String phone) {
		super();
		this.orgCode = orgCode;
		this.phone = phone;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
