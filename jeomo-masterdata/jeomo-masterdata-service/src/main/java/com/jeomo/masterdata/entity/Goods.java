package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:15
 * @Version 1.0
 */
public class Goods extends BaseEntity {

    /**
     * 商户ID
     */
    private Integer merchantId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存信息
     */
    private Integer stock;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
