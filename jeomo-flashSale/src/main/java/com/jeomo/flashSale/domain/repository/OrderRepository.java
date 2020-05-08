package com.jeomo.flashSale.domain.repository;

import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.domain.entity.order.OrderGoods;
import com.jeomo.flashSale.domain.repository.dao.OrderGoodsMapper;
import com.jeomo.flashSale.domain.repository.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 订单仓储服务
 * @Author: qbt
 * @Date: 2020/3/20 18:48
 * @Version 1.0
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;


    /**
     * 保存订单
     * @return
     */
    public int save(Order order) {
        orderMapper.insert(order);
        if(order.getGoods() != null) {
            for(OrderGoods goods : order.getGoods()) {
                goods.setOrderId(order.getId());
                orderGoodsMapper.insert(goods);
            }
        }
        return 1;
    }

    public Order queryOrder(Long orderId) {
        return null;
    }


}
