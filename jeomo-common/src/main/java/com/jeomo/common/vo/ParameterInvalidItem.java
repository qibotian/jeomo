package com.jeomo.common.vo;

/**
 * 参数项无效
 * @Author: qbt
 * @Date: 2019/4/10 23:33
 * @Version 1.0
 */
public class ParameterInvalidItem {

    /**
     * 参数名称
     */
    private  String fieldName;

    /**
     * 提示信息
     */
    private String message;


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
