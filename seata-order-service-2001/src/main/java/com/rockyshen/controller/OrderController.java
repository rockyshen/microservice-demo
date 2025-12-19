package com.rockyshen.controller;

import com.rockyshen.model.Order;
import com.rockyshen.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rockyshen
 * @date 2025/12/18 22:12
 */
@RestController("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public String create(Order order) {
        orderService.create(order);
        return "ok";
    }
}
