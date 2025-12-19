package com.rockyshen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 扣减账户余额：RPC
 * @author rockyshen
 * @date 2025/12/19 10:05
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi {
    @PostMapping("/account/decrease")
    String decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
