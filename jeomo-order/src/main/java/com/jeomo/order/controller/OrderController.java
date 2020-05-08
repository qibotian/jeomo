package com.jeomo.order.controller;

import com.jeomo.common.controller.BaseController;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.masterdata.service.IGoodsService;
import com.jeomo.order.entity.Order;
import com.jeomo.order.service.IOrderService;
import com.jeomo.order.vo.NewOrderGoodsVo;
import com.jeomo.order.vo.NewOrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/3/1 16:27
 * @Version 1.0
 */
@RequestMapping("/masterdata/basedata")
@ResponseResult
@RestController
public class OrderController extends BaseController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IGoodsService goodsService;


    @PostMapping("save")
    public boolean save(@RequestBody NewOrderVo vo) {
        Order order = new Order();
        BeanUtils.copyProperties(vo, order);
        List<NewOrderGoodsVo> goods = vo.getGoods();
        for(NewOrderGoodsVo good : goods) {
            boolean hasStockReduceSuccess = goodsService.reduceStock(good.getGoodsId(), good.getNum());
            if(!hasStockReduceSuccess) {
                return false;
            }
        }



        return orderService.save(order);
    }


}
