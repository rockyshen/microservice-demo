package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.mapper.AccountMapper;
import com.rockyshen.model.Account;
import com.rockyshen.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
* @author junjie.shen
* @description 针对表【t_account】的数据库操作Service实现
* @createDate 2025-12-19 11:32:55
*/
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

    @Resource
    AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, Long money)
    {
        log.info("------->account-service中扣减账户余额开始");

        accountMapper.decrease(userId,money);

//        myTimeOut();
//        int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }

    /**
     * 模拟超时异常，全局事务回滚
     * feign默认RPC的超时时间是60s
     */
    private static void myTimeOut()
    {
        try { TimeUnit.SECONDS.sleep(65); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}




