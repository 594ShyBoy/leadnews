package com.lead.admin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName GatewayApplication
 * @date 2021/5/24 18:25
 * @Version 1.0
 * @Author ShyBoy
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启注册中心
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
