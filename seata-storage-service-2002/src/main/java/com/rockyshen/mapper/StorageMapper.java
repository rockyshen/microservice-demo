package com.rockyshen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rockyshen.model.Storage;
import org.apache.ibatis.annotations.Param;

/**
* @author junjie.shen
* @description 针对表【t_storage】的数据库操作Mapper
* @createDate 2025-12-19 11:28:59
* @Entity generator.domain.Storage
*/
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}




