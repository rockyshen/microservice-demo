package com.rockyshen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    /**
     * 利用jmeter：10个线程，1秒钟全部发完。
     * 这里的服务端响应时间设置了1秒。每个请求一定会大于熔断规则设置的200ms，符合熔断条件
     * 所以当线程开启1秒后，就会进入熔断状态
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("-----测试：新增熔断规则-慢调用比例");
        return "testF 洗增熔断规则-慢调用比例";
    }
}
