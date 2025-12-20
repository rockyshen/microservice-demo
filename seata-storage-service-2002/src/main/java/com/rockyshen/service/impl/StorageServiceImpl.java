package com.rockyshen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockyshen.model.Storage;
import com.rockyshen.service.StorageService;
import com.rockyshen.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author junjie.shen
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2025-12-19 11:28:59
*/
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
    implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}




