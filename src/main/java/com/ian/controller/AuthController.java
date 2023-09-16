package com.ian.controller;

import com.ian.pojo.Result;

import com.ian.pojo.entity.Auth;
import com.ian.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 21:12
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/auth-tree")
    public Result getAuthTree(){
        List<Auth> authTree = authService.selectAuthTree();
        return Result.ok(authTree);
    }
}
