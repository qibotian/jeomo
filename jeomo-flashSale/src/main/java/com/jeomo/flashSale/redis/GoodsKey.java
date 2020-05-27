package com.jeomo.flashSale.redis;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qbt
 * @Date: 2020/5/19 22:27
 * @Version 1.0
 */
public class GoodsKey extends BaseRedisKey {

    private final static String MIAO_SHA_GOODS_STOCK_KEY_PREFIX = "GOODS_MS_STOCK:";

    private final static Long MIAO_SHA_GOODS_STOCK_KEY_EXPIRE = 10L;

    private final static TimeUnit MIAO_SHA_GOODS_STOCK_KEY_TIME_UNIT = TimeUnit.SECONDS;


    public GoodsKey(String key, Long expire, TimeUnit expireTimeUnit) {
        super(key, expire, expireTimeUnit);
    }

    public static GoodsKey newMiaoShaStockKey(Long goodsId) {
        return new GoodsKey(MIAO_SHA_GOODS_STOCK_KEY_PREFIX + goodsId, MIAO_SHA_GOODS_STOCK_KEY_EXPIRE, MIAO_SHA_GOODS_STOCK_KEY_TIME_UNIT);
    }



}
