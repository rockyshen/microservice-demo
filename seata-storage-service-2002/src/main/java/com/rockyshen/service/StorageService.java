package com.rockyshen.service;

import com.rockyshen.model.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author junjie.shen
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2025-12-19 11:28:59
*/
public interface StorageService extends IService<Storage> {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);


}
