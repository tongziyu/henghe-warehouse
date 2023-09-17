package com.ian.mapper;

import com.ian.pojo.entity.RoleAuth;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 根据roleId删除该角色的所有权限
     * @param roleId
     */
    @Delete("delete from role_auth where role_id = #{roleId}")
    void deleteByRoleId(Integer roleId);

    /**
     * 插入role auth
     * @param roleAuth
     */
    @Insert("insert into role_auth(role_id, auth_id) values(#{roleId},#{authId})")
    void insert(RoleAuth roleAuth);
}
