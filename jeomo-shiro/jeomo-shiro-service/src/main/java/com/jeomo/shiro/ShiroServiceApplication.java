package com.jeomo.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qbt
 * @Date: 2020/7/27 8:21
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages ={"com.jeomo"})
@EnableDiscoveryClient
public class ShiroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroServiceApplication.class, args);
    }

}
