package com.ian.service;

import com.ian.pojo.dto.AuthGrantDTO;

import java.util.List;

public interface RoleAuthService {
    /**
     * 根据roleId查询出所有的AuthId
     * @param roleId
     * @return
     */
    List<Integer> getAuthIdsByRoleId(Integer roleId);

    /**
     * 授权
     * @param authGrantDTO
     */
    void authGrant(AuthGrantDTO authGrantDTO);
}
