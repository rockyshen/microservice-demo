package com.rockyshen.controller;

import com.rockyshen.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rockyshen
 * @date 2025/12/19 11:47
 */
@RestController
@RequestMapping(("/storage"))
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/decrease")
    public String decrease(long productId, Integer count){
        storageService.decrease(productId, count);
        return "扣减库存成功!";
    }
}
