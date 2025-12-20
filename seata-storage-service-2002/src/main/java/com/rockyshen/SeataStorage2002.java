package com.rockyshen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author rockyshen
 * @date 2025/12/19 10:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.rockyshen.mapper")
public class SeataStorage2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorage2002.class);
    }
}