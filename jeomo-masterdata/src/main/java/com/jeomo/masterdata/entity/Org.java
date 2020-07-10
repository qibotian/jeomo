package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

/**
 * 组织
 * 权限隔离的最高粒度，不同组织的之间的数据是绝对透明的
 * @Author: qbt
 * @Date: 2020/7/7 23:00
 * @Version 1.0
 */
public class Org extends BaseEntity {
	
    /**  */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织码
	 */
	private String code;
	
    /**
     * 组织名称
     */
    private String orgName;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
