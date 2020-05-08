package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qbt
 * @Date: 2020/3/1 1:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Merchant extends BaseEntity {

    /**
     * 所属商场ID
     */
    private Integer mallId;

    /**
     * 商户ID
     */
    private Integer merchantId;

    /**
     * 商户名称
     */
    private String name;


}
