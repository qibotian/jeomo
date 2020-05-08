package com.jeomo.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数项无效
 * @Author: qbt
 * @Date: 2019/4/10 23:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParameterInvalidItem {

    /**
     * 参数名称
     */
    private  String fieldName;

    /**
     * 提示信息
     */
    private String message;


}
