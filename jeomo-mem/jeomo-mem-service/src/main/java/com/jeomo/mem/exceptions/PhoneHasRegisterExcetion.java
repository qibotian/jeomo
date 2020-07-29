package com.jeomo.mem.exceptions;

import com.jeomo.common.exception.BusinessException;

public class PhoneHasRegisterExcetion extends BusinessException {

	public PhoneHasRegisterExcetion() {
        super("手机号已被注册");
    }

	private static final long serialVersionUID = 1L;

}
