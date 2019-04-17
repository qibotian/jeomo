package com.jeomo.common.result.annotation;

import com.jeomo.common.result.PlatformResult;
import com.jeomo.common.result.Result;

import java.lang.annotation.*;

/**
 * 接口返回结果增强  会通过拦截器拦截后放入标记，在ResponseResultHandler 进行结果处理
 * @Author: qbt
 * @Date: 2019/4/10 23:35
 * @Version 1.0
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  ResponseResult {

    Class<? extends Result>  value() default PlatformResult.class;

}
