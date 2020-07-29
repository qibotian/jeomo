package com.jeomo.mem.dto;

/**
 * <p>标题: 组织下的最大会员编号 </p>
 * @author qibotian
 * @time 2020年7月14日 下午2:42:06
 */
public class OrgMaxMemberCodeDto {

	private Long mallId;
	
	private String maxCardNo;

	public Long getMallId() {
		return mallId;
	}

	public void setMallId(Long mallId) {
		this.mallId = mallId;
	}

	public String getMaxCardNo() {
		return maxCardNo;
	}

	public void setMaxCardNo(String maxCardNo) {
		this.maxCardNo = maxCardNo;
	}
	
}
