package com.ian.service.impl;

import com.ian.mapper.AuthMapper;
import com.ian.pojo.Auth;
import com.ian.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 23:49
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    /**
     * 返回权限菜单树
     * @param userId
     * @return
     */
    @Cacheable(cacheNames = "authTree",key = "#userId")
    @Override
    public List<Auth> selectAuthTreeByUserId(Integer userId) {

        List<Auth> auths = authMapper.selectAuthByUserId(userId);

        List<Auth> auths1 = allAuthToAuthTree(auths,0);

        return auths1;
    }

    /**
     * 生成权限菜单树,固定代码
     * 将所有权限(菜单)转成权限(菜单)树的递归算法
     */
    private List<Auth> allAuthToAuthTree(List<Auth> allAuthList, int parentId){
        //获取父权限(菜单)id为参数parentId的所有权限(菜单)
        //【parentId最初为0,即最初查的是所有一级权限(菜单)】
        List<Auth> authList = new ArrayList<>();
        for (Auth auth : allAuthList) {
            if(auth.getParentId()==parentId){
                authList.add(auth);
            }
        }
        //查询List<Auth> authList中每个权限(菜单)的所有子级权限(菜单)
        for (Auth auth : authList) {
            List<Auth> childAuthList = allAuthToAuthTree(allAuthList, auth.getAuthId());
            auth.setChildAuth(childAuthList);
        }
        return authList;
    }
}
