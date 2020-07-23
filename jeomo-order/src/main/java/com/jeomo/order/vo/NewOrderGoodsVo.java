package com.jeomo.order.vo;

/**
 * @Author: qbt
 * @Date: 2020/3/8 16:02
 * @Version 1.0
 */

public class NewOrderGoodsVo {

    /**
     * 商品Id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer num;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
