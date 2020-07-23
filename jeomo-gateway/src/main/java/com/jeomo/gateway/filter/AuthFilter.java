package com.jeomo.gateway.filter;

import com.alibaba.nacos.client.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * 鉴权过滤器
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    private final Logger logger = LogUtils.logger(AuthFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("通过鉴权过滤器");
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
