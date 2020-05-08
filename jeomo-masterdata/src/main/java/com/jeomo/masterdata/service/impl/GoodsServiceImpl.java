package com.jeomo.masterdata.service.impl;

import com.jeomo.common.service.impl.BaseServiceImpl;
import com.jeomo.masterdata.entity.Goods;
import com.jeomo.masterdata.mapper.GoodsMapper;
import com.jeomo.masterdata.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * @Author: qbt
 * @Date: 2020/3/8 15:35
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Override
    public boolean reduceStock(Long goodsId, Integer stock) {
        return this.baseMapper.reduceStock(goodsId, stock) > 0;
    }
}
