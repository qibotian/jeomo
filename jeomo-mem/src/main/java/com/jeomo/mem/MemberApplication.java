package com.jeomo.mem;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: qbt
 * @Date: 2019/3/24 20:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.jeomo.mem")
@ImportResource({"classpath:dubbo.xml"})
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ={"com.jeomo"})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class,args);

    }



}
