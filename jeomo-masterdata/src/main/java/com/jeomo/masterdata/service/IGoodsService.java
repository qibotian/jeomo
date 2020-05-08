package com.jeomo.masterdata.service;

import com.jeomo.common.service.IBaseService;
import com.jeomo.masterdata.entity.Goods;

/**
 * @Author: qbt
 * @Date: 2020/3/8 15:32
 * @Version 1.0
 */
public interface IGoodsService extends IBaseService<Goods> {

    /**
     * 减少库存
     * @param goodsId
     * @param stock
     * @return
     */
    boolean reduceStock(Long goodsId, Integer stock);

}
