package com.jeomo.mem.dto;

/**
 * <p>标题: 购物中心群组最大卡号</p>
 * @author qibotian
 * @time 2020年7月14日 下午2:41:39
 */
public class MallGroupMaxCardCodeDto {

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
