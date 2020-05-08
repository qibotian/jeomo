package com.jeomo.flashSale.application.service;

import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.interfaces.dto.FlashSaleReqDto;

/**
 * @Author: qbt
 * @Date: 2020/3/20 18:31
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 秒杀
     * @return
     */
    Order flashSaling(FlashSaleReqDto dto);



}
