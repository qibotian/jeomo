package com.jeomo.flashSale.interfaces.dto;


/**
 * 秒杀请求DTO
 * @Author: qbt
 * @Date: 2020/3/20 18:21
 * @Version 1.0
 */
public class FlashSaleReqDto {

    /**
     * 顾客ID
     */
    private Long customerId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 秒杀活动ID不能为空
     */
    private Long activityId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
