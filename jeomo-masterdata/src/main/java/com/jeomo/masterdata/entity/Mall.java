package com.jeomo.masterdata.entity;

import com.jeomo.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物中心
 * @Author: qbt
 * @Date: 2020/3/1 0:06
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mall extends BaseEntity {

    /**
     * 所属组织
     */
    private Integer orgId;

    /**
     * 同城店Id
     */
    private Integer groupId;

    /**
     * 购物中心编号
     */
    private Integer mallId;

    /**
     * 购物中心名称
     */
    private String name;



}
