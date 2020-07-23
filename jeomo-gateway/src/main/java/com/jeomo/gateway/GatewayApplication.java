package com.jeomo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
public class GatewayApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(GatewayApplication.class, args);
    }
}
