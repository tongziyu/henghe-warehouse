package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.RoleQueryPageDTO;
import com.ian.pojo.dto.UserAssignRoleDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.vo.RoleQueryPageVo;
import com.ian.service.RoleService;
import com.ian.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;

    /**
     * 获取所有的角色信息
     * @return
     */
    @GetMapping("/role-list")
    public Result getRoleList(){
        List<Role> roleList = roleService.getRoleList();

        return Result.ok(roleList);
    }

    /**
     * 分页查询角色
     * roleName=     &roleCode=      &roleState=
     * &pageSize=5       &pageNum=1       &totalNum=0
     * @return
     */
    @GetMapping("/role-page-list")
    public Result rolePageList(RoleQueryPageDTO roleQueryPageDTO){
        RoleQueryPageVo roleQueryPageVo = roleService.getRolePageList(roleQueryPageDTO);
        return Result.ok(roleQueryPageVo);
    }
}
