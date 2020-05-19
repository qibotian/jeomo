package com.jeomo.flashSale.redis;

/**
 * @Author: qbt
 * @Date: 2020/5/19 22:27
 * @Version 1.0
 */
public class GoodsKey extends  BaseRedisKeyPrefix {

    private  GoodsKey(String prefix, int expire){
        super(prefix, expire);
    }

    public static GoodsKey getMiaoShaGoodsStockKey = new GoodsKey("gms", 0);

}
