package com.jeomo.flashSale.exception;

import com.jeomo.common.exception.BusinessException;

/**
 * @Author: qbt
 * @Date: 2020/5/8 11:37
 * @Version 1.0
 */
public class IllegalActivityException extends BusinessException {
    /**  */
	private static final long serialVersionUID = 1L;

	public IllegalActivityException() {
        super("活动已经结束了。");
    }
}
