package com.ian.service;


import com.ian.pojo.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * 获取所有的角色信息
     * @return
     */
    List<Role> getRoleList();

}
