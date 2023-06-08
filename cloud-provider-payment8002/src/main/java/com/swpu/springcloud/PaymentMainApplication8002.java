package com.swpu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
public class PaymentMainApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApplication8002.class,args);
    }
}
