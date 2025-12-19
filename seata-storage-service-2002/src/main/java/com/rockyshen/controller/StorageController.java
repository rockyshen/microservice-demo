package com.rockyshen.controller;

import com.rockyshen.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rockyshen
 * @date 2025/12/19 11:47
 */
@RestController("/storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public String decrease(@RequestParam("productId") long productId, @RequestParam("count") Integer count){

        return "ok";
    }
}
