package com.jeomo.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/3/8 16:02
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class NewOrderGoodsVo {

    /**
     * 商品Id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer num;

}
