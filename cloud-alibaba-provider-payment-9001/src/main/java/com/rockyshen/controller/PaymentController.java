package com.rockyshen.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rockyshen
 * @date 2025/12/15 09:35
 */
@RestController
public class PaymentController {
    @GetMapping("/pay/nacos/get/{orderId}")
    @SentinelResource(value = "getPayInfoByOrderId", blockHandler = "handlerBlockHandler")   // 流量控制
    public String getPayInfoByOrderId(@PathVariable("orderId") String orderId) {
        return "返回值：payId=1024, OrderId="+ orderId;
    }

    // 这里是触发流控规则
    public String handlerBlockHandler(@PathVariable("orderId") String orderId, BlockException e){
        return "getPayInfoByOrderId服务不可用，触发Sentinel流控限制规则";
    }
}
