package com.rockyshen.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 整合open-feign和sentinel，在open-feign层面进行服务熔断、降级
 * @author rockyshen
 * @date 2025/12/15 09:54
 */

// FeignClient的value，写的是：服务提供者provider，注册到nacos中的服务名
// fallback，写的是通用的服务熔断类，所有通过feign的接口方法降级都会走这个（类似于全局异常处理类GlobalException）
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderId}")
    public String getPayInfoByOrderId(@PathVariable("orderId") String orderId);
}
