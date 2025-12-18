package com.rockyshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rockyshen
 * @date 2025/12/18 22:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// @MapperScan 是否需要？
public class SeataOrder2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001.class);
    }
}