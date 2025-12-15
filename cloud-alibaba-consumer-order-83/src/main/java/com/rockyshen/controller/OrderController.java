package com.rockyshen.controller;

import com.rockyshen.feign.PayFeignSentinelApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rockyshen
 * @date 2025/12/15 13:23
 */
@RestController
public class OrderController {
    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @GetMapping(value = "/consumer/pay/nacos/get/{orderId}")
    public String getPayInfoByOrderId(@PathVariable("orderId") String orderId) {
        return payFeignSentinelApi.getPayInfoByOrderId(orderId);
    }
}
