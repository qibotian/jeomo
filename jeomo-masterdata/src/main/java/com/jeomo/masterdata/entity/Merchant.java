package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:16
 * @Version 1.0
 */
public class Merchant extends BaseEntity {

    /**  */
	private static final long serialVersionUID = 1L;
	
	private Integer orgId;

	/**
     * 所属商场ID
     */
    private Integer mallId;

    /**
     * 商户ID
     */
    private Integer merchantId;

    /**
     * 商户名称
     */
    private String name;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getMallId() {
        return mallId;
    }

    public void setMallId(Integer mallId) {
        this.mallId = mallId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
