package com.jeomo.flashSale.domain.repository;

import com.jeomo.flashSale.domain.entity.flash.FlashSaleActivity;
import com.jeomo.flashSale.domain.repository.dao.FlashSaleActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: qbt
 * @Date: 2020/3/25 23:15
 * @Version 1.0
 */
@Repository
public class FlashSaleActivityRepository {

    @Autowired
    FlashSaleActivityMapper flashSaleActivityMapper;

    public FlashSaleActivity getById(Long id) {
        return  flashSaleActivityMapper.selectById(id);
    }

    public int flash(Long activityId, Long goodsId) {
        return flashSaleActivityMapper.flash(activityId, goodsId);
    }


}
