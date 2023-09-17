package com.ian.service.impl;

import com.ian.mapper.RoleAuthMapper;
import com.ian.pojo.dto.AuthGrantDTO;
import com.ian.pojo.entity.RoleAuth;
import com.ian.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 22:35
 */
@Service
@Slf4j
public class RoleAuthServiceImpl implements RoleAuthService {
    @Autowired
    private RoleAuthMapper roleAuthMapper;

    /**
     * 根据roleId查询出所有的AuthId
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> getAuthIdsByRoleId(Integer roleId) {
        List<Integer> authIds = roleAuthMapper.selectAuthIdsByRoleId(roleId);
        return authIds;
    }

    /**
     * 授权
     * @param authGrantDTO
     */
    @Override
    @Transactional
    public void authGrant(AuthGrantDTO authGrantDTO) {
        List<Integer> authIds = authGrantDTO.getAuthIds();
        Integer roleId = authGrantDTO.getRoleId();

        /*
        思路:
            - 先删除:通过roleId删除所有的记录条数
            - 再插入:再循环插入所有的权限
         */
        roleAuthMapper.deleteByRoleId(roleId);

        for (Integer authId: authIds){
            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setRoleId(roleId);
            roleAuth.setAuthId(authId);
            roleAuthMapper.insert(roleAuth);
        }
    }
}
