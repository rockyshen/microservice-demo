package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.feign.AccountFeignApi;
import com.rockyshen.feign.StorageFeignApi;
import com.rockyshen.model.Order;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.rockyshen.service.OrderService;
import com.rockyshen.mapper.OrderMapper;

import javax.annotation.Resource;

/**
* @author shen
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2025-12-18 22:16:37
*/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderService orderService;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    public void create(Order order) {
        // seata的全局事务id
        String xid = RootContext.getXID();
        log.info("------开始新建订单，xid= "+xid);
        // 1、订单新建前，初始订单状态默认是0
        order.setStatus(0);
        // 此时order对象身上就有id了
        int res = orderMapper.insert(order);
        // 2、插入订单成功后，拿到插入mysql成功的实体对象
        if(res > 0){
            Order orderFromDb = orderService.getById(order.getId());
            log.info("----> 新建订单成功，orderFromDb info: " + orderFromDb);
            // 3、扣减库存
            log.info("----> 订单微服务开始RPC调用storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDb.getProduct_id(),orderFromDb.getCount());
            log.info("----> 订单微服务开始RPC调用storage库存，做扣减完成");
            // 4、扣减余额
            log.info("----> 订单微服务开始RPC调用account库存，做扣减money");
            accountFeignApi.decrease(orderFromDb.getUser_id(),orderFromDb.getMoney());
            log.info("----> 订单微服务开始RPC调用account库存，做扣减完成");
            // 5、更新订单状态为1
            order.setStatus(1);
            boolean b = orderService.saveOrUpdate(order);
            log.info("----> 修改订单状态结果："+ b);
            log.info("----> orderFromDb info："+ orderFromDb);
        }
        log.info("------结束新建订单，xid= "+xid);
    }
}




