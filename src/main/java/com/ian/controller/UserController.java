package com.ian.controller;

import com.ian.pojo.dto.UserAddDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.Auth;
import com.ian.pojo.Result;
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

    @GetMapping("/user-list")
    public Result getUserList(UserQueryPageDTO userQueryPageDTO){
        log.info("分页查询数据:{}",userQueryPageDTO);
        UserQueryPageVO userList = userService.getUserList(userQueryPageDTO);
        return Result.ok(userList);
    }

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
        user.setCreateTime(new Date());
        user.setUserState("0");

        userService.addUser(user);
        return Result.ok();
    }
}
