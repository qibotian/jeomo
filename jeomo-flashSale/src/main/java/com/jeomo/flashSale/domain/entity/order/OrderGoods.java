package com.jeomo.flashSale.domain.entity.order;

import com.jeomo.common.entity.BaseEntity;
import com.jeomo.flashSale.infrastructure.BigDecimalUtils;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: qbt
 * @Date: 2020/3/20 17:44
 * @Version 1.0
 */
@Data
@Builder
public class OrderGoods extends BaseEntity {

    private Long orderId;

    /**
     * 商品Id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 获取总价
     * @return
     */
    public BigDecimal countPrice() {
        BigDecimal goodsPrice = new BigDecimal(0); // TODO
        return BigDecimalUtils.mul(goodsPrice, goodsNum);
    }

}
