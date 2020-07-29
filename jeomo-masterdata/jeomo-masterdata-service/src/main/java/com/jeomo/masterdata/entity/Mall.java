package com.jeomo.masterdata.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;

/**
 * 购物中心
 * @Author: qbt
 * @Date: 2020/3/1 0:06
 * @Version 1.0
 */
@TableName("sys_mall")
public class Mall extends BaseEntity {

    /**  */
	private static final long serialVersionUID = 1L;
	
	/**
     * 所属组织
     */
    private String orgCode;

    /**
     * 同城店Id
     */
    private String groupCode;
    
    /**
     * 购物中心号
     */
    private String code;

    /**
     * 购物中心名称
     */
    private String name;


    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
