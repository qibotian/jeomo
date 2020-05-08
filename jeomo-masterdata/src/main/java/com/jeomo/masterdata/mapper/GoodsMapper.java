package com.jeomo.masterdata.mapper;

import com.jeomo.common.mapper.IBaseMapper;
import com.jeomo.masterdata.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: qbt
 * @Date: 2020/3/8 15:35
 * @Version 1.0
 */
@Mapper
public interface GoodsMapper extends IBaseMapper<Goods> {

    int reduceStock(Long id, Integer reduceStock);


}
