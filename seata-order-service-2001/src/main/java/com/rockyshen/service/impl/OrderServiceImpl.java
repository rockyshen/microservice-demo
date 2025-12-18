package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.model.Order;
import org.springframework.stereotype.Service;
import com.rockyshen.service.OrderService;
import com.rockyshen.mapper.OrderMapper;

/**
* @author shen
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2025-12-18 22:16:37
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}




