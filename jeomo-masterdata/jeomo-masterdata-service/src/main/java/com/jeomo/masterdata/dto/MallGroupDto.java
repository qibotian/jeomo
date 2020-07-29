package com.jeomo.masterdata.dto;

import java.io.Serializable;

/**
 * 同城店
 * @Author: qbt
 * @Date: 2020/3/1 0:08
 * @Version 1.0
 */
public class MallGroupDto implements Serializable{

	/**  */
	private static final long serialVersionUID = 1L;

	/**
	 * 族群所属的组织号
	 */
    private String orgCode;

    /**
     * 族群号
     */
    private String code; 
    
    /**
     * 族群名称
     */
    private String name;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

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
