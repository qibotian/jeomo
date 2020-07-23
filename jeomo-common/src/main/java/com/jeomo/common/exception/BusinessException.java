package com.jeomo.common.exception;

import com.jeomo.common.enums.ResultCode;

/**
 * @Author: qbt
 * @Date: 2019/4/10 22:55
 * @Version 1.0
 */

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private ResultCode resultCode;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

	public ResultCode getResultCode() {
		return resultCode;
	}

}
