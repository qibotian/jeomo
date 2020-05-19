package com.jeomo.flashSale.application.service.impl;

import com.jeomo.flashSale.application.service.OrderService;
import com.jeomo.flashSale.domain.entity.customer.Customer;
import com.jeomo.flashSale.domain.entity.flash.FlashSaleActivity;
import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.domain.repository.FlashSaleActivityRepository;
import com.jeomo.flashSale.domain.repository.OrderRepository;
import com.jeomo.flashSale.interfaces.dto.FlashSaleReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: qbt
 * @Date: 2020/3/20 18:32
 * @Version 1.0
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FlashSaleActivityRepository flashSaleActivityRepository;




    @Override
    public Order flashSaling(FlashSaleReqDto dto) {

        //判断秒杀活动是否结束

        //判断用户是否参与过秒杀活动

        //预减库存

        //将秒杀信息放入到MQ中

        Long customerId = dto.getCustomerId();
        Long goodsId = dto.getGoodsId();
        //查询顾客是否已经参与过秒杀活动
        FlashSaleActivity activity = flashSaleActivityRepository.getById(dto.getActivityId());
        int result = flashSaleActivityRepository.flash(activity.getId(), dto.getGoodsId());
        if(result > 0) {
            System.out.println("顾客" + customerId + " 秒杀成功");
            Customer customer = new Customer(customerId);
            Order order = customer.flash(dto.getGoodsId());
            orderRepository.save(order);
            return order;
        }
        System.out.println("顾客" + customerId + " 秒杀失败");
        return null;
    }
}
