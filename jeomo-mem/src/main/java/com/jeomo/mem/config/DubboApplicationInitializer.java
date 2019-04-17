package com.jeomo.mem.config;

import org.springframework.core.annotation.Order;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @Author: qbt
 * @Date: 2019/3/27 13:47
 * @Version 1.0
 */
@Order(1)
public class DubboApplicationInitializer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("111111111111111111111111111111111111111");
    }
}
