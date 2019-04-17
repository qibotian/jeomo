package com.jeomo.common.exception;

import com.jeomo.common.enums.ResultCode;
import lombok.Getter;

/**
 * @Author: qbt
 * @Date: 2019/4/10 22:55
 * @Version 1.0
 */

@Getter
public class BusinessException extends Exception {

    private ResultCode resultCode;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }


}
