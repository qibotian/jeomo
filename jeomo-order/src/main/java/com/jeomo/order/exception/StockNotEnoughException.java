package com.jeomo.order.exception;

import com.jeomo.common.exception.BusinessException;

/**
 * @Author: qbt
 * @Date: 2020/3/8 16:06
 * @Version 1.0
 */
public class StockNotEnoughException extends BusinessException {
    public StockNotEnoughException(String msg) {
        super(msg);
    }
}
