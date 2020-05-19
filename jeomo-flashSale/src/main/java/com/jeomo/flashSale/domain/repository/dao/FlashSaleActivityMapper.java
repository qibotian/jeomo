package com.jeomo.flashSale.domain.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeomo.flashSale.domain.entity.flash.FlashSaleActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: qbt
 * @Date: 2020/3/25 23:14
 * @Version 1.0
 */
@Mapper
public interface FlashSaleActivityMapper extends BaseMapper<FlashSaleActivity> {


    @Update("update flash_sale_activity set num = num - 1, version = version + 1 where id = #{activityId} and goods_id = #{goodsId} and num >= 1")
    int flash(Long activityId, Long goodsId);


}
