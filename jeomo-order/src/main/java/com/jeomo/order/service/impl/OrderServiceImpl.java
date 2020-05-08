package com.jeomo.order.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.order.entity.Order;
import com.jeomo.order.mapper.OrderMapper;
import com.jeomo.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * OrderService
 * @Author: qbt
 * @Date: 2020/3/1 16:35
 * @Version 1.0
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Order saveOrder(Order order) {
        return null;
    }
}
