package com.rockyshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 实验spring-cloud-alibaba
 * @author rockyshen
 * @date 2025/12/8 11:41
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8848 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8848.class);
    }
}
