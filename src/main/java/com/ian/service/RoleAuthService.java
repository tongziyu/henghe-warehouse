package com.ian.service;

import java.util.List;

public interface RoleAuthService {
    /**
     * 根据roleId查询出所有的AuthId
     * @param roleId
     * @return
     */
    List<Integer> getAuthIdsByRoleId(Integer roleId);
}
