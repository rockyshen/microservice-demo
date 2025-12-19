package com.rockyshen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 扣减库存：RPC
 * @author rockyshen
 * @date 2025/12/19 10:06
 */
@FeignClient("seata-storage-service")
public interface StorageFeignApi {
    @PostMapping(value = "/storage/decrease")
    String decrease(@RequestParam("productId") long productId, @RequestParam("count") Integer count);
}
