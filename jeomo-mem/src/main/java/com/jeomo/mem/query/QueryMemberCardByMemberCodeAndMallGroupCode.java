package com.jeomo.mem.query;

/**
 * <p>标题: 根据会员号 和门店号查询会员卡信息</p>
 * @author qibotian
 * @time 2020年7月16日 下午3:28:56
 */
public class QueryMemberCardByMemberCodeAndMallGroupCode {
	
	private String memberCode;
	
	private String mallGroupCode;
	
	public QueryMemberCardByMemberCodeAndMallGroupCode(String memberCode, String mallGroupCode) {
		super();
		this.memberCode = memberCode;
		this.mallGroupCode = mallGroupCode;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMallGroupCode() {
		return mallGroupCode;
	}

	public void setMallGroupCode(String mallGroupCode) {
		this.mallGroupCode = mallGroupCode;
	}
}
