package com.rockyshen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rockyshen
 * @date 2025/12/19 11:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.rockyshen.mapper")
public class SeataAccount2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccount2003.class);
    }
}