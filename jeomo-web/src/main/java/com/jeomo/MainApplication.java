package com.jeomo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: qbt
 * @Date: 2019/3/20 19:10
 * @Version 1.0
 */

@SpringBootApplication
@EnableDubboConfig
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


}
