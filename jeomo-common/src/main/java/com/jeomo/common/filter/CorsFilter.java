package com.jeomo.common.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 因为要前后端分离
 * 所以这里要跨域访问过滤设置
 * @Author: qbt
 * @Date: 2019/4/10 18:45
 * @Version 1.0
 */
@Component
@WebFilter
@Order(Integer.MIN_VALUE)
public class CorsFilter implements Filter {

    private static final String PARAMS_SEPARATE = ", ";

    @Value("${cors.access.control.maxAge:7200}")
    String corsAccessControlMaxAge;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            response.getWriter().println("ok");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String getHeaders(HttpServletRequest httpServletRequest) {
        StringBuilder params = new StringBuilder();
        String accessControlRequestHeaders = httpServletRequest.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS);
        if (!(accessControlRequestHeaders == null || accessControlRequestHeaders.isEmpty())) {
            params.append(accessControlRequestHeaders).append(PARAMS_SEPARATE);
        }

        Enumeration<String> names = httpServletRequest.getHeaderNames();
        while (names.hasMoreElements()) {
            params.append(names.nextElement()).append(PARAMS_SEPARATE);
        }
        params.setLength(params.length() - PARAMS_SEPARATE.length());
        return params.toString();
    }

    @Override
    public void destroy() {

    }
}
