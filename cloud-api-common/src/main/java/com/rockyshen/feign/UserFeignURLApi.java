package com.rockyshen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 基于固定 URL 的 Feign 客户端（不经 Nacos 服务发现）
 * name：客户端标识，必填
 * url：真实请求地址，写死后直接 HTTP 调用该主机
 */
@FeignClient(name = "user-feign-url-api", url = "${user-center.base-url:http://127.0.0.1:9010}")
public interface UserFeignURLApi {

    /**
     * 按工号查询用户信息（user-center 内部接口）
     */
    @GetMapping("/internal/user/work-number/{workNumber}")
    String getByWorkNumber(@PathVariable("workNumber") Long workNumber,
                           @RequestHeader("X-Internal-Service-Token") String internalToken);
}
