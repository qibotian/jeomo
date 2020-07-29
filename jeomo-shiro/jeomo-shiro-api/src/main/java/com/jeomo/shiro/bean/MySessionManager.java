package com.jeomo.shiro.bean;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 自定义认证管理
 * @Author: qbt
 * @Date: 2019/5/11 15:17
 * @Version 1.0
 */

public class MySessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";


    public MySessionManager() {
        super();
    }

    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        Serializable sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(sessionId)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
        } else {
            // 否则按默认规则从cookie取sessionId
            // System.out.println(super.getSessionId(request, response));
            sessionId = (String) super.getSessionId(request, response);
        }
        System.out.println("*************获取sessionId************" + sessionId);
        return sessionId;
    }

}
