package com.jeomo.order.entity;

import com.jeomo.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @Author: qbt
 * @Date: 2020/3/1 2:17
 * @Version 1.0
 */
public class OrderGoods extends BaseEntity {

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsNum;

    private BigDecimal price;

    private BigDecimal discountAmount;

    private BigDecimal realAmount;

}
