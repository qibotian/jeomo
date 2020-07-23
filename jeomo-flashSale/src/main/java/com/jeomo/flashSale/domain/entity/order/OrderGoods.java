package com.jeomo.flashSale.domain.entity.order;

import com.jeomo.common.entity.BaseEntity;
import com.jeomo.flashSale.infrastructure.BigDecimalUtils;

import java.math.BigDecimal;

/**
 * @Author: qbt
 * @Date: 2020/3/20 17:44
 * @Version 1.0
 */
public class OrderGoods extends BaseEntity {

    private Long orderId;

    /**
     * 商品Id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 获取总价
     * @return
     */
    public BigDecimal countPrice() {
        BigDecimal goodsPrice = new BigDecimal(0); // TODO
        return BigDecimalUtils.mul(goodsPrice, goodsNum);
    }

    public OrderGoods(Long orderId, Long goodsId, Integer goodsNum) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
