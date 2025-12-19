package com.rockyshen.controller;

import com.rockyshen.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rockyshen
 * @date 2025/12/19 11:48
 */
@RestController("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public String decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        return "ok";
    }
}
