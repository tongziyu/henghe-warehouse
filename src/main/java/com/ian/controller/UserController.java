package com.ian.controller;

import com.ian.pojo.dto.UserAddDTO;
import com.ian.pojo.dto.UserAssignRoleDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.Auth;
import com.ian.pojo.Result;
import com.ian.pojo.entity.Role;
import com.ian.pojo.entity.User;
import com.ian.pojo.vo.UserQueryPageVO;
import com.ian.service.AuthService;
import com.ian.service.UserService;
import com.ian.utils.CurrentUser;
import com.ian.utils.DigestUtil;
import com.ian.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    private UserService userService;



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

    /**
     * 分页查询员工
     * @param userQueryPageDTO
     * @return
     */
    @GetMapping("/user-list")
    public Result getUserList(UserQueryPageDTO userQueryPageDTO){
        log.info("分页查询数据:{}",userQueryPageDTO);
        UserQueryPageVO userList = userService.getUserList(userQueryPageDTO);
        return Result.ok(userList);
    }

    /**
     * 添加员工
     * @param userAddDTO
     * @param token
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserAddDTO userAddDTO,
                          @RequestHeader("token") String token
    ){

        User user = new User();
        log.info("添加用户:{}",userAddDTO);

        // 获得当前用户的id
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        BeanUtils.copyProperties(userAddDTO,user);
        // 对密码进行MD5加密
        user.setUserPwd(DigestUtil.hmacSign(userAddDTO.getUserPwd()));
        user.setCreateBy(currentUser.getUserId());
        user.setCreateTime(LocalDateTime.now());
        user.setUserState("0");
        user.setIsDelete("0");

        userService.addUser(user);
        return Result.ok();
    }

    /**
     * 修改员工状态
     */
    @PutMapping("/updateState")
    public Result updateState(@RequestBody User user,
                              @RequestHeader("token") String token
    ){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);

        log.info("修改的用户:{}",user);
        user.setUpdateBy(currentUser.getUserId());
        user.setUpdateTime(LocalDateTime.now());

        userService.updateStateByUserId(user);
        return Result.ok(Result.CODE_OK);
    }


    /**
     * 通过用户id查询出来该用户所有的角色
     * @param userId
     * @return
     */
    @GetMapping("/user-role-list/{userId}")
    public Result getUserRoleList(@PathVariable("userId") Integer userId){
        List<Role> roleList = userService.getUserRoleListByUserId(userId);

        return Result.ok(roleList);
    }

    /**
     * 给用户分配角色
     * @return
     */
    @PutMapping("/assignRole")
    public Result assignRole(@RequestBody UserAssignRoleDTO userAssignRoleDTO){
        log.info("给用户分配角色:{}",userAssignRoleDTO);
        userService.assignRole(userAssignRoleDTO);

        return Result.ok();
    }
}
