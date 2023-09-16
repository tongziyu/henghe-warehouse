package com.ian.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleAuthMapper {

    /**
     * 根据角色ID查询出来所有权限ID
     * @param roleId
     * @return
     */
    List<Integer> selectAuthIdsByRoleId(Integer roleId);
}
