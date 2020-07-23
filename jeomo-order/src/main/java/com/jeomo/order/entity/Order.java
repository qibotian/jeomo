package com.jeomo.order.entity;

import com.jeomo.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:20
 * @Version 1.0
 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
