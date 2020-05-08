package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:15
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods extends BaseEntity {

    /**
     * 商户ID
     */
    private Integer merchantId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存信息
     */
    private Integer stock;

}
