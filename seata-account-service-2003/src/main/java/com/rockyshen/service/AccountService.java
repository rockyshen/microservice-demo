package com.rockyshen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rockyshen.model.Account;
import org.apache.ibatis.annotations.Param;

/**
* @author junjie.shen
* @description 针对表【t_account】的数据库操作Service
* @createDate 2025-12-19 11:32:55
*/
public interface AccountService extends IService<Account> {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
