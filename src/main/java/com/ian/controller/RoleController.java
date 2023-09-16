package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.entity.Role;
import com.ian.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 14:41
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有的角色信息
     * @return
     */
    @GetMapping("/role-list")
    public Result getRoleList(){
        List<Role> roleList = roleService.getRoleList();

        return Result.ok(roleList);
    }


}
