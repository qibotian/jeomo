package com.jeomo.flashSale.interfaces.api;

import com.jeomo.flashSale.application.service.OrderService;
import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.interfaces.dto.FlashSaleReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qbt
 * @Date: 2020/3/20 18:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/flashSale")
public class FlashSaleApi {


    @Autowired
    OrderService orderService;

    @RequestMapping("/flash")
    public Order flash(@RequestBody  FlashSaleReqDto dto) {
        return  orderService.flashSaling(dto);
    }






}
