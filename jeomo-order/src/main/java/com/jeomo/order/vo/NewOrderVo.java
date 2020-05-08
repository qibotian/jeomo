package com.jeomo.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/3/8 15:18
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class NewOrderVo {

    /**
     * 商场Id
     */
    private Long mallId;

    /**
     * 商户Id
     */
    private Long merchantId;

    /**
     * 订单来源
     */
    private Integer orderFrom;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 商品列表
     */
    List<NewOrderGoodsVo> goods;

}
