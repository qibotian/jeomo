package com.jeomo.config;

import com.jeomo.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: qbt
 * @Date: 2019/4/10 23:38
 * @Version 1.0
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        //响应结果控制拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(apiUri);
    }

}
