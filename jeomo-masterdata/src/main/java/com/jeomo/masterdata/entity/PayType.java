package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;

/**
 * @Author: qbt
 * @Date: 2020/3/1 2:32
 * @Version 1.0
 */
public class PayType extends BaseEntity {

    /**
     * 支付方式码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 参数配置
     */
    private String config;

    /**
     * 描述
     */
    private String memo;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 是否折扣
     */
    private Boolean discount;

    /**
     * 是否线上支付
     * 比如现金，纸质券之类的为线下支付
     */
    private Boolean online;

}
