package com.jeomo.bonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages ={"com.jeomo"})
@Configuration
@EnableFeignClients(basePackages ="com.jeomo")
@EnableHystrix
public class BonusApplication {
	
	
    public static void main( String[] args ) {
        SpringApplication.run(BonusApplication.class, args);
    }
    
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
    	HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    	ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
    	registrationBean.setLoadOnStartup(1);
    	registrationBean.addUrlMappings("/hystrix.stream");
    	registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
    
    
}
