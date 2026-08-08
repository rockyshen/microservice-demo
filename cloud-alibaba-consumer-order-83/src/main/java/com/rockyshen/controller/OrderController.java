package com.rockyshen.controller;

import com.rockyshen.feign.PayFeignSentinelApi;
import com.rockyshen.feign.UserFeignURLApi;
import org.springframework.beans.factory.annotation.Value;
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

    @Resource
    private UserFeignURLApi userFeignURLApi;

    @Value("${user-center.internal-token}")
    private String userCenterInternalToken;

    @GetMapping(value = "/consumer/pay/nacos/get/{orderId}")
    public String getPayInfoByOrderId(@PathVariable("orderId") String orderId) {
        return payFeignSentinelApi.getPayInfoByOrderId(orderId);
    }

    /**
     * 模拟 order 调 user：Feign + 固定 URL 直连本机 user-center
     */
    @GetMapping(value = "/consumer/user/work-number/{workNumber}")
    public String getUserByWorkNumber(@PathVariable("workNumber") Long workNumber) {
        return userFeignURLApi.getByWorkNumber(workNumber, userCenterInternalToken);
    }
}
