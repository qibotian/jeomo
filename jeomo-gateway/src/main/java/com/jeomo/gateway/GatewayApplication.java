package com.jeomo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableEurekaClient
public class GatewayApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(GatewayApplication.class, args);
    }
}
