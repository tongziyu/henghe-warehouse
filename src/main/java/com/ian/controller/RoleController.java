package com.ian.controller;

import com.ian.mapper.RoleMapper;
import com.ian.pojo.Result;
import com.ian.pojo.dto.RoleAddDTO;
import com.ian.pojo.dto.RoleQueryPageDTO;
import com.ian.pojo.dto.RoleUpdateDTO;
import com.ian.pojo.dto.UserAssignRoleDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.vo.RoleQueryPageVo;
import com.ian.service.RoleAuthService;
import com.ian.service.RoleService;
import com.ian.service.UserService;
import com.ian.utils.CurrentUser;
import com.ian.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private RoleAuthService roleAuthService;

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

    /**
     * 修改角色状态
     * @param role
     * @param token
     * @return
     */
    @PutMapping("/role-state-update")
    public Result roleStateUpdate(@RequestBody Role role,
                                  @RequestHeader("token") String token
                                  ){
        log.info("修改角色状态:{}",role);
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);

        role.setUpdateBy(currentUser.getUserId());
        role.setUpdateTime(LocalDateTime.now());

        roleService.updateRoleState(role);

        return Result.ok("修改状态成功!!");
    }

    /**
     * 添加角色
     * @param roleAddDTO
     * @param token
     * @return
     */
    @PostMapping("/role-add")
    public Result roleAdd(@RequestBody RoleAddDTO roleAddDTO,
                          @RequestHeader("token") String token
    ){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        Role role = Role.builder()
                .roleState("0")
                .roleName(roleAddDTO.getRoleName())
                .roleDesc(roleAddDTO.getRoleDesc())
                .roleCode(roleAddDTO.getRoleCode())
                .createBy(currentUser.getUserId())
                .createTime(LocalDateTime.now())
                .build();
        roleService.addRole(role);
        return Result.ok("添加成功!!");
    }

    /**
     * 修改角色
     * @return
     */
    @PutMapping("/role-update")
    public Result roleUpdate(@RequestBody RoleUpdateDTO roleUpdateDTO,
                             @RequestHeader("token") String token
                             ){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        Role role = Role.builder()
                .roleDesc(roleUpdateDTO.getRoleDesc())
                .roleId(roleUpdateDTO.getRoleId())
                .updateBy(currentUser.getUserId())
                .updateTime(LocalDateTime.now())
                .build();

        roleService.updateRoleDesc(role);
        return Result.ok("修改成功!!");
    }

    @DeleteMapping("/role-delete/{roleId}")
    public Result roleDeleteByRoleId(@PathVariable("roleId") Integer roleId){
        // 直接删除role
        roleService.deleteRoleByRoleId(roleId);

        return Result.ok("删除成功!!");
    }

    /**
     * 根据roleId查询所有的AuthId
     * @param roleId
     * @return
     */
    @GetMapping("/role-auth")
    public Result getAuthIdsByRoleId(Integer roleId){
        List<Integer> authList = roleAuthService.getAuthIdsByRoleId(roleId);
        return Result.ok(authList);
    }

}
