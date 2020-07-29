package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;


/**
 * 基础数据
 *  是否： 0否 1是
 *  会员状态 0正常 1冻结 2 注销
 *  积分业务类型 1 普通消费  2 消费退货 3 手工调整 4 注册送积分 5 其他
 *  订单状态  1已完成 2 已关闭
 *  订单来源 1 线下商城 2 微信平台 3支付宝平台
 *
 *
 *
 * @Author: qbt
 * @Date: 2020/3/1 1:44
 * @Version 1.0
 */
public class BaseData extends BaseEntity {

    private Long typeId;

    private Integer code;

    private String name;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
