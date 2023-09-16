package com.ian.service.impl;

import com.ian.mapper.RoleAuthMapper;
import com.ian.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
