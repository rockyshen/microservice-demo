package com.rockyshen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流量监控
 * @author rockyshen
 * @date 2025/12/9 09:50
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }

    @GetMapping("/testC")
    public String testC(){
        System.out.println(System.currentTimeMillis() + "-----testC 排队等待");
        return "-----testC";
    }
}
