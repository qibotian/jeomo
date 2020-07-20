package com.jeomo.mem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:03
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.jeomo"})
@EnableEurekaClient //开启Eureka客户端
@EnableCircuitBreaker //开启断路器
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);

    }



}
