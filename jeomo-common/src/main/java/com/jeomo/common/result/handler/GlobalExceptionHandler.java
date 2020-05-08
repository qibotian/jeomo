package com.jeomo.common.result.handler;

import com.jeomo.common.exception.BusinessException;
import com.jeomo.common.result.DefaultErrorResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理
 * @Author: qbt
 * @Date: 2019/4/10 23:16
 * @Version 1.0
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler{

    /**
     *  处理400类异常
     * */
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public DefaultErrorResult handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        return super.handleBindException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return super.handleMethodArgumentNotValidException(e, request);
    }

    /**
     * 权限认证失败
     * @param e
     * @param request
     * @return
     */
    @Override
    @ExceptionHandler(IncorrectCredentialsException.class)
    public DefaultErrorResult handleIncorrectCredentialsException(IncorrectCredentialsException e, HttpServletRequest request) {
        return super.handleIncorrectCredentialsException(e, request);
    }

    /**
     * 权限认证失败
     * @param e
     * @param request
     * @return
     */
    @Override
    @ExceptionHandler(UnknownAccountException.class)
    public DefaultErrorResult handleUnknownAccountException(UnknownAccountException e, HttpServletRequest request) {
        return super.handleUnknownAccountException(e, request);
    }

    @Override
    @ExceptionHandler(UnauthenticatedException.class)
    public DefaultErrorResult handleUnauthenticatedException(UnauthenticatedException e, HttpServletRequest request) {
        return super.handleUnauthenticatedException(e, request);
    }



    /* 处理自定义异常 */
    @Override
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<DefaultErrorResult> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return super.handleBusinessException(e, request);
    }

    /* 处理运行时异常 */
    @Override
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public DefaultErrorResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        //TODO 可通过邮件、微信公众号等方式发送信息至开发人员、记录存档等操作（这个后面我们文章我们单独说明该怎么处理）
        return super.handleRuntimeException(e, request);
    }



}
