package com.jeomo.order.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends BaseEntity {

    /**
     * 商场Id
     */
    private Long mallId;

    /**
     * 商户Id
     */
    private Long merchantId;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 订单来源
     */
    private Integer orderFrom;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 是否已退款
     */
    private Boolean refund;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 折扣后金额
     */
    private BigDecimal realAmount;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 积分信息
     */
    private Integer point;

}
