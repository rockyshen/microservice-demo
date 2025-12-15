package com.rockyshen.feign;

import org.springframework.stereotype.Component;

/**
 * sentinel服务降级fallback整合到
 * @author rockyshen
 * @date 2025/12/15 09:59
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public String getPayInfoByOrderId(Integer orderId) {
        return "feign提供方的服务不可用，FallBack服务降级";
    }
}
