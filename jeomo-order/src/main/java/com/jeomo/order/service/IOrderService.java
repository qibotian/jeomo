package com.jeomo.order.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.order.entity.Order;

/**
 * @Author: qbt
 * @Date: 2020/3/1 16:25
 * @Version 1.0
 */
public interface IOrderService extends IBaseService<Order> {

    Order saveOrder(Order vo);

}
