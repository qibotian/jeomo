package com.jeomo.common.enums;

import com.jeomo.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

/**
 * @Author: qbt
 * @Date: 2019/4/10 22:56
 * @Version 1.0
 */
public enum ExceptionEnum {

    BUSINESS_DEMO_EXCEPTION(ResultCode.PARAM_IS_INVALID,HttpStatus.BAD_GATEWAY);

    private ResultCode resultCode;

    private HttpStatus httpStatus;

    ExceptionEnum(ResultCode resultCode, HttpStatus httpStatus) {
        this.resultCode = resultCode;
        this.httpStatus = httpStatus;
    }

    public static ExceptionEnum getByEClass(Class<? extends BusinessException> aClass) {
        return BUSINESS_DEMO_EXCEPTION;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }




}
