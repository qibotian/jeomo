package com.jeomo.flashSale.infrastructure;

import java.math.BigDecimal;

/**
 * BigDecimal 工具类
 * @Author: qbt
 * @Date: 2020/3/20 17:49
 * @Version 1.0
 */
public class BigDecimalUtils {

    private static final int DEFALUT_SCALE = 2;

    /**
     * 乘法
     * @param value1
     * @param value2
     * @return
     */
    public static BigDecimal mul(BigDecimal value1, BigDecimal value2) {
        return value1.multiply(value2);
    }

    /**
     * 乘法
     * @param value1
     * @param value2
     * @return
     */
    public static BigDecimal mul(BigDecimal value1, Integer value2) {
        BigDecimal v2 = BigDecimal.valueOf(value2);
        return mul(value1, v2);
    }

    /**
     * 加法
     * @param value1
     * @param value2
     * @return
     */
    public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }


}
