package com.jeomo.flashSale.interfaces.dto;

import lombok.Data;

/**
 * 秒杀请求DTO
 * @Author: qbt
 * @Date: 2020/3/20 18:21
 * @Version 1.0
 */
@Data
public class FlashSaleReqDto {

    /**
     * 顾客ID
     */
    private Long customerId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 秒杀活动ID不能为空
     */
    private Long activityId;

}
