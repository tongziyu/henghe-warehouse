package com.ian.service.impl;

import com.ian.mapper.RoleMapper;
import com.ian.pojo.entity.Role;
import com.ian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 14:44
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取所有的角色信息
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleMapper.selectRoleAll();
        return roleList;
    }
}
