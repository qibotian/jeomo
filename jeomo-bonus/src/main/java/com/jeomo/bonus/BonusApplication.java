package com.jeomo.bonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages ={"com.jeomo"})
@Configuration
@EnableFeignClients(basePackages ="com.jeomo")
public class BonusApplication {
    public static void main( String[] args ) {
        SpringApplication.run(BonusApplication.class, args);
    }
}
