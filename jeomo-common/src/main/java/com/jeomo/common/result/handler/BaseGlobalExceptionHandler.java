package com.jeomo.common.result.handler;

import com.jeomo.common.enums.ResultCode;
import com.jeomo.common.exception.BusinessException;
import com.jeomo.common.result.DefaultErrorResult;
import com.jeomo.common.util.ParameterInvalidItemHelper;
import com.jeomo.common.vo.ParameterInvalidItem;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: qbt
 * @Date: 2019/4/10 23:24
 * @Version 1.0
 */

@RestController
@ControllerAdvice
public class BaseGlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(BaseGlobalExceptionHandler.class);

    /**
     * 处理验证参数封装错误时异常
     */
    @ExceptionHandler
    protected DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.info("handleConstraintViolationException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理参数绑定时异常（反400错误码）
     */
    @ExceptionHandler
    protected DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        log.info("handleBindException start, uri:{}, caused by: ", request.getRequestURI(), e);
        List<ParameterInvalidItem> parameterInvalidItemList = ParameterInvalidItemHelper.convertBindingResultToMapParameterInvalidItemList(e.getBindingResult());
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList);
    }

    /**
     * 处理使用@Validated注解时，参数验证错误异常（反400错误码）
     */
    @ExceptionHandler
    protected DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.info("handleMethodArgumentNotValidException start, uri:{}, caused by: ", request.getRequestURI(), e);
        List<ParameterInvalidItem> parameterInvalidItemList = ParameterInvalidItemHelper.convertBindingResultToMapParameterInvalidItemList(e.getBindingResult());
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList);
    }

    /**
     * 处理通用自定义业务异常
     */
    @ExceptionHandler
    protected ResponseEntity<DefaultErrorResult> handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.info("handleBusinessException start, uri:{}, exception:{}, caused by: {}", request.getRequestURI(), e.getClass(), e.getMessage());
        DefaultErrorResult defaultErrorResult = DefaultErrorResult.failure(e);
        return ResponseEntity
                .status(HttpStatus.valueOf(defaultErrorResult.getStatus()))
                .body(defaultErrorResult);
    }


    @ExceptionHandler
    protected DefaultErrorResult handleIncorrectCredentialsException(IncorrectCredentialsException e, HttpServletRequest request) {
        log.info("handleIncorrectCredentialsException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.UNAUTHORIZED, e, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    protected DefaultErrorResult handleUnknownAccountException(UnknownAccountException e, HttpServletRequest request) {
        log.info("handleUnknownAccountException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.UNKNOWNACCOUNT, e, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    protected DefaultErrorResult handleUnauthenticatedException(UnauthenticatedException e, HttpServletRequest request) {
        log.info("handleUnauthenticatedException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.UNAUTHORIZED, e, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    protected DefaultErrorResult handleUnauthenticatedException(UnauthorizedException e, HttpServletRequest request) {
        log.info("handleUnauthenticatedException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.UNAUTHORIZED, e, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 处理运行时系统异常（反500错误码）
     */
    @ExceptionHandler
    protected DefaultErrorResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        log.error("handleRuntimeException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.SYSTEM_INNER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
