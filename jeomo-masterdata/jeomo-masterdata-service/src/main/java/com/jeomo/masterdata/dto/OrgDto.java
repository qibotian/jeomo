package com.jeomo.masterdata.dto;

import java.io.Serializable;

/**
 * 权限隔离的最高粒度，不同组织的之间的数据是绝对透明的
 * @Author: qbt
 * @Date: 2020/7/7 23:00
 * @Version 1.0
 */
public class OrgDto implements Serializable {
	
    /**  */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织码
	 */
	private String code;
	
    /**
     * 组织名称
     */
    private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
