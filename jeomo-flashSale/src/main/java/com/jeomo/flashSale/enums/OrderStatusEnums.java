package com.jeomo.flashSale.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 订单状态
 * @Author: qbt
 * @Date: 2020/3/20 18:13
 * @Version 1.0
 */
public enum OrderStatusEnums implements IEnum<Integer> {

    /**
     * 待支付
     */
    TO_BE_PAID(0, "待支付"),

    /**
     * 待发货
     */
    TO_BE_SHIPPED(1, "代发货"),

    /**
     * 待收货
     */
    TO_BE_RECEIVED(2, "待收货"),

    /**
     * 已取消
     */
    CANCELED(3, "已取消");

    @EnumValue
    private final int code;

    private final String desc;

    OrderStatusEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    @JsonValue
    public  String getDesc() {
        return  desc;
    }

}
