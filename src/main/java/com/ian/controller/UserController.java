package com.ian.controller;

import com.ian.pojo.Auth;
import com.ian.pojo.Result;
import com.ian.service.AuthService;
import com.ian.utils.CurrentUser;
import com.ian.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 21:12
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthService authService;

    @Autowired
    private TokenUtils tokenUtils;

    /**
     * 用户权限菜单树
     * @return
     */
    @GetMapping("/auth-list")

    public Result authList(@RequestHeader("token") String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        Integer userId = currentUser.getUserId();
        List<Auth> auths = authService.selectAuthTreeByUserId(userId);

        return Result.ok(auths);
    }
}
