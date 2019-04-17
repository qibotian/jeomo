package com.jeomo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: qbt
 * @Date: 2019/4/2 20:43
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GatewayMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class, args);
    }

}
