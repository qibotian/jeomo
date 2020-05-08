package com.jeomo.flashSale.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "顾客ID不能为空")
    private Long customerId;

    /**
     * 商品ID
     */
    @NotNull(message = "商品ID不能为空")
    private Long goodsId;

    /**
     * 秒杀活动ID不能为空
     */
    @NotNull(message = "秒杀活动ID不能为空")
    private Long activityId;

}
