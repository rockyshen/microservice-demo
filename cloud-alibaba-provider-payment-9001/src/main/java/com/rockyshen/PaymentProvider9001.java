package com.rockyshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * openfeign的服务提供方
 * @author rockyshen
 * @date 2025/12/15 09:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProvider9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider9001.class);
    }
}