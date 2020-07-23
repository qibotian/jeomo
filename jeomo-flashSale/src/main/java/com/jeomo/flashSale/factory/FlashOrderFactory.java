package com.jeomo.flashSale.factory;

import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.enums.OrderStatusEnums;

import java.util.Date;

/**
 * 订单工程
 * @Author: qbt
 * @Date: 2020/3/20 17:37
 * @Version 1.0
 */
public class FlashOrderFactory {

    public  static Order createOrder(Long customerId, Long goodsId) {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setCustomerId(customerId);
        order.setOrderNo(newOrderNo());
        order.setStatus(OrderStatusEnums.TO_BE_PAID);
        return order;
    }

    /**
     * 生成一个订单编号
     * @return
     */
    private static String newOrderNo(){
        return String.valueOf(System.currentTimeMillis());
    }


}
