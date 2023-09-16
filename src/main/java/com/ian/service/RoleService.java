package com.ian.service;


import com.ian.pojo.dto.RoleQueryPageDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.vo.RoleQueryPageVo;

import java.util.List;

public interface RoleService {

    /**
     * 获取所有的角色信息
     * @return
     */
    List<Role> getRoleList();

    /**
     * 分页查询角色
     * @param roleQueryPageDTO
     * @return
     */
    RoleQueryPageVo getRolePageList(RoleQueryPageDTO roleQueryPageDTO);

    /**
     * 修改状态
     * @param role
     */
    void updateRoleState(Role role);

    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 更新角色描述信息
     * @param role
     */
    void updateRoleDesc(Role role);
}
