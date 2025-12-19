package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.model.Account;
import com.rockyshen.service.AccountService;
import com.rockyshen.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
* @author junjie.shen
* @description 针对表【t_account】的数据库操作Service实现
* @createDate 2025-12-19 11:32:55
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

}




