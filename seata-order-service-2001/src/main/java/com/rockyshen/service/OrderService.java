package com.rockyshen.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.rockyshen.model.Order;

/**
* @author shen
* @description 针对表【t_order】的数据库操作Service
* @createDate 2025-12-18 22:16:37
*/

public interface OrderService extends IService<Order> {
    void create(Order order);
}
