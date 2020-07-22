package com.jeomo.bonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.jeomo"})
@EnableCircuitBreaker //开启断路器
@EnableDiscoveryClient
@EnableFeignClients(basePackages ={"com.jeomo"})
public class BonusApplication {
	
	
    public static void main( String[] args ) {
        SpringApplication.run(BonusApplication.class, args);
    }
    

}
