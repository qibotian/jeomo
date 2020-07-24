package com.jeomo.common.enums;

/**
 * 错误码
 * @Author: qbt
 * @Date: 2019/4/10 22:41
 * @Version 1.0
 */
public enum ResultCode {

    SUCCESS(20000,"成功"),
    UNKNOWNACCOUNT(401, "无效的用户"),
    UNAUTHORIZED(403, "权限认证失败"),
    PARAM_IS_INVALID(400001, "参数无效"),
    SYSTEM_INNER_ERROR(500001, "系统错误" ),
    ;



    Integer code;
    String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return this.code;
    }
    public String msg() {
        return this.msg;
    }
}
