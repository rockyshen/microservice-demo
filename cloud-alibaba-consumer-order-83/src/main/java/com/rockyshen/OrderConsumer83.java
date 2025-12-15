package com.rockyshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rockyshen
 * @date 2025/12/15 10:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer83.class);
    }
}