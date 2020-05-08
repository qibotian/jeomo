package com.jeomo.flashSale.domain.entity.flash;

import com.jeomo.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @Author: qbt
 * @Date: 2020/3/25 23:02
 * @Version 1.0
 */
@Data
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


}
