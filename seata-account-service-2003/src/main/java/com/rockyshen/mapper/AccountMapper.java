package com.rockyshen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rockyshen.model.Account;
import org.apache.ibatis.annotations.Param;

/**
* @author junjie.shen
* @description 针对表【t_account】的数据库操作Mapper
* @createDate 2025-12-19 11:32:55
* @Entity generator.domain.Account
*/
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}




