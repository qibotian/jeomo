package com.jeomo.bonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.jeomo"})
@EnableDiscoveryClient
public class BonusApplication {


    public static void main( String[] args ) {
        SpringApplication.run(BonusApplication.class, args);
    }


}
