package com.lead.wmmedia.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName WmGatewayApplication
 * @date 2021/5/29 18:07
 * @Version 1.0
 * @Author ShyBoy
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启注册中心
public class WmGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WmGatewayApplication.class,args);
    }
}
