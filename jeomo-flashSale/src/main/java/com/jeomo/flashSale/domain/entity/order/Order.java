package com.jeomo.flashSale.domain.entity.order;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jeomo.common.entity.BaseEntity;
import com.jeomo.flashSale.enums.OrderStatusEnums;
import com.jeomo.flashSale.infrastructure.BigDecimalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 秒单
 * @Author: qbt
 * @Date: 2020/3/20 17:28
 * @Version 1.0
 */

@TableName("`order`")
public class Order extends BaseEntity {

    private final static int DEFAULT_FLASH_GOODS_NUM = 1;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 顾客ID
     */
    private Long customerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private OrderStatusEnums status;

    /**
     * 秒杀商品ID
     */
    @TableField(exist = false)
    private List<OrderGoods> goods;

    /**
     * 支付
     */
    public void pay() {
        //支付后，将订单状态改为代发货
        this.status = OrderStatusEnums.TO_BE_SHIPPED;
    }

    /**
     * 计算总价
     * @return
     */
    public BigDecimal countPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(OrderGoods og : goods) {
            totalPrice =  BigDecimalUtils.add(og.countPrice(), totalPrice);
        }
        return totalPrice;
    }

    /**
     * 添加秒杀商品，商品数量默认是1
     * @param goodsId
     */
    public void addFlashGoods(Long goodsId) {
        addOrderGoods(goodsId, DEFAULT_FLASH_GOODS_NUM);
    }

    /**
     * 新增或者删除一个商品
     */
    public void addOrderGoods(Long goodsId, Integer goodsNum) {
        if(goods == null) {goods = new ArrayList<>();}
        for(OrderGoods og : goods) {
            if(og.getGoodsId().equals(goodsId)) {
                og.setGoodsNum(goodsNum + og.getGoodsNum());
                return;
            }
        }
        OrderGoods orderGoods = new OrderGoods(getId(), goodsId, goodsNum);
        goods.add(orderGoods);
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public OrderStatusEnums getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnums status) {
        this.status = status;
    }

    public List<OrderGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoods> goods) {
        this.goods = goods;
    }
}
