package com.jeomo.flashSale.domain.entity.customer;

import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.factory.FlashOrderFactory;
import lombok.Data;

/**
 * 秒杀的参与者 顾客
 * @Author: qbt
 * @Date: 2020/3/20 17:25
 * @Version 1.0
 */
@Data
public class Customer {

    private Long id;

    public Customer(Long id) {
        super();
        this.id = id;
    }

    /**
     * 参加秒杀，并返回秒杀订单
     * @return
     */
    public Order flash(Long goodsId) {
        Order order = FlashOrderFactory.createOrder(getId(), goodsId);
        order.addFlashGoods(goodsId);
        return order;
    }

    /**
     * 支付
     */
    public void pay(Order order) {
        //进行支付
        order.pay();
    }


}
