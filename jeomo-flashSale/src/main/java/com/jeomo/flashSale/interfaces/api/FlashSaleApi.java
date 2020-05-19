package com.jeomo.flashSale.interfaces.api;

import com.jeomo.flashSale.application.service.OrderService;
import com.jeomo.flashSale.domain.entity.order.Order;
import com.jeomo.flashSale.interfaces.dto.FlashSaleReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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
    public Order flash() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(500);
        for(int i = 0; i < 500; i++) {
            long finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    FlashSaleReqDto dto = new FlashSaleReqDto();
                    dto.setActivityId(1L);
                    dto.setGoodsId(1L);
                    dto.setCustomerId(finalI);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    Order order = orderService.flashSaling(dto);
                }
            });
            t.start();
        }
        return null;
    }






}
