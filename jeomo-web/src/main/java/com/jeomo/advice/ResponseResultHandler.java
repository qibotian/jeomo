package com.jeomo.advice;

import com.alibaba.fastjson.JSON;
import com.jeomo.ResponseResultInterceptor;
import com.jeomo.common.result.DefaultErrorResult;
import com.jeomo.common.result.PlatformResult;
import com.jeomo.common.result.Result;
import com.jeomo.common.result.annotation.ResponseResult;
import com.jeomo.consts.HeaderConstants;
import com.jeomo.enums.ApiStyleEnum;
import com.jeomo.util.RequestContextHolderUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qbt
 * @Date: 2019/4/10 23:38
 * @Version 1.0
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = RequestContextHolderUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn != null && !ApiStyleEnum.NONE.name().equalsIgnoreCase(request.getHeader(HeaderConstants.API_STYLE));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseResult responseResultAnn = (ResponseResult) RequestContextHolderUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);

        Class<? extends Result> resultClazz = responseResultAnn.value();

        if (resultClazz.isAssignableFrom(PlatformResult.class)) {
            if (body instanceof DefaultErrorResult) {
                DefaultErrorResult defaultErrorResult = (DefaultErrorResult) body;
                return PlatformResult.builder()
                        .code(Integer.valueOf(defaultErrorResult.getCode()))
                        .msg(defaultErrorResult.getMsg())
                        .data(defaultErrorResult.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JSON.toJSONString(PlatformResult.success(body));
            }
            return PlatformResult.success(body);
        }

        return body;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(PlatformResult.success("123")));;
    }
}
