package com.ian.service;

import com.ian.pojo.entity.Auth;

import java.util.List;

public interface AuthService {
    /**
     * 返回权限菜单树
     * @param userId
     * @return
     */
    List<Auth> selectAuthTreeByUserId(Integer userId);
}
