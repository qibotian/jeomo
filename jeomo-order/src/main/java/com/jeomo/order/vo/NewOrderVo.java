package com.jeomo.order.vo;

import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/3/8 15:18
 * @Version 1.0
 */
public class NewOrderVo {

    /**
     * 商场Id
     */
    private Long mallId;

    /**
     * 商户Id
     */
    private Long merchantId;

    /**
     * 订单来源
     */
    private Integer orderFrom;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 商品列表
     */
    List<NewOrderGoodsVo> goods;

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<NewOrderGoodsVo> getGoods() {
        return goods;
    }

    public void setGoods(List<NewOrderGoodsVo> goods) {
        this.goods = goods;
    }
}
