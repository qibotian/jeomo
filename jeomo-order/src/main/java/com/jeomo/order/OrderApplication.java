package com.jeomo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qbt
 * @Date: 2020/3/1 16:50
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages ={"com.jeomo"})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}
