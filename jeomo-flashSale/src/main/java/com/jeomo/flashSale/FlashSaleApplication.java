package com.jeomo.flashSale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qbt
 * @Date: 2020/3/22 16:56
 * @Version 1.0
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages ={"com.jeomo"})
public class FlashSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashSaleApplication.class,args);
    }


}
