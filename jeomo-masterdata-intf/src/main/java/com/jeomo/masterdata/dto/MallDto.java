package com.jeomo.masterdata.dto;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:17
 * @Version 1.0
 */
public class MallDto {

    /**
     * 所属组织
     */
    private Long orgId;

    /**
     * 同城店Id
     */
    private Long groupId;

    /**
     * 购物中心编号
     */
    private Long baseId;

    /**
     * 购物中心名称
     */
    private String name;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getBaseId() {
		return baseId;
	}

	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
