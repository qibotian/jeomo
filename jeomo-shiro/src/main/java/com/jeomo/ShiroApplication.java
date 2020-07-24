package com.jeomo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * shiroApplication
 */
@SpringBootApplication
@Configuration
@EnableTransactionManagement
public class ShiroApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ShiroApplication.class, args);
    }
}
