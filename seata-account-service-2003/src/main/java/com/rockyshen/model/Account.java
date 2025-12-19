package com.rockyshen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName t_account
 */
@TableName(value ="t_account")
@Data
public class Account {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long user_id;

    /**
     * 总额度
     */
    private Integer total;

    /**
     * 已用余额
     */
    private Integer used;

    /**
     * 剩余可用额度
     */
    private Integer residue;
}