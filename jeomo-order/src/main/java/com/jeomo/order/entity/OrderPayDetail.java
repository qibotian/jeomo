package com.jeomo.order.entity;

import java.math.BigDecimal;

/**
 * 订单支付信息
 * @Author: qbt
 * @Date: 2020/3/1 2:36
 * @Version 1.0
 */
public class OrderPayDetail {

    /**
     * 支付方式ID
     */
    private Long payTypeId;

    /**
     * 支付金额
     */
    private BigDecimal amount;


}
