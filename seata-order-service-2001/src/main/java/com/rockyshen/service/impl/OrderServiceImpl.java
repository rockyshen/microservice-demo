package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.feign.AccountFeignApi;
import com.rockyshen.feign.StorageFeignApi;
import com.rockyshen.model.Order;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
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
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    // seata的分布式全局事务：name是seata网页上用来定位的；rollbackFor是当发生指定异常时回滚，这里是指定全部Exception都回滚
    @GlobalTransactional(name = "rockyshen-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        //xid全局事务id的检查，重要
        String xid = RootContext.getXID();
        //1 新建订单
        log.info("---------------开始新建订单: "+"\t"+"xid: "+xid);
        //订单新建时默认初始订单状态是零
        order.setStatus(0);
        // 使用 MyBatis-Plus 的 save 方法插入，插入后 order 对象会自动回填主键 id
        boolean result = this.save(order);

        if(result)
        {
            // 使用 MyBatis-Plus 的 getById 方法查询刚插入的记录
            Order orderFromDB = this.getById(order.getId());
            log.info("-----> 新建订单成功,orderFromDB info: "+orderFromDB);
            System.out.println();
            //2 扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(orderFromDB.getProductId(),orderFromDB.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();

            //3 扣减账户余额
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(orderFromDB.getUserId(),orderFromDB.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();

            //4 修改订单状态
            //将订单状态从零修改为1，表示已经完成
            log.info("-------> 修改订单状态");

            // 使用 MyBatis-Plus 的 LambdaUpdateWrapper 构建更新条件
            LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(Order::getUserId, orderFromDB.getUserId())
                         .eq(Order::getStatus, 0)
                         .set(Order::getStatus, 1);

            boolean updateResult = this.update(updateWrapper);
            log.info("-------> 修改订单状态完成"+"\t"+updateResult);
            log.info("-------> orderFromDB info: "+orderFromDB);
        }
        System.out.println();
        log.info("---------------结束新建订单: "+"\t"+"xid: "+xid);
    }
}
