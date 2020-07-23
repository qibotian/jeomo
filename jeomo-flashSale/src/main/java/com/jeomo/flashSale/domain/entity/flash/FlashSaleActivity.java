package com.jeomo.flashSale.domain.entity.flash;

import com.jeomo.common.entity.BaseEntity;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/3/25 23:02
 * @Version 1.0
 */
public class FlashSaleActivity extends BaseEntity {

    private Long id;

    /**
     * 秒杀活动的名称
     */
    private String name;


    /**
     * 秒杀开始时间
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;

    /**
     * 参与秒杀的商品ID
     */
    private Long goodsId;

    /**
     * 参与秒杀的数量
     */
    private Integer num;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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
