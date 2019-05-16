package com.jeomo.com.jeomo.shiro.controller;

import com.jeomo.com.jeomo.shiro.vo.LoginVo;
import com.jeomo.common.result.annotation.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qbt
 * @Date: 2019/5/11 14:43
 * @Version 1.0
 */
@RestController
@ResponseResult
public class SignController {

    Logger logger = LoggerFactory.getLogger(SignController.class);

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestBody LoginVo loginVo) {
        logger.info("用户登录，username:{}", loginVo.getUsername());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getUsername(), loginVo.getPassword());
        subject.login(token);
        return subject.getSession().getId().toString();
    }

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        throw new UnauthenticatedException();
    }

}
