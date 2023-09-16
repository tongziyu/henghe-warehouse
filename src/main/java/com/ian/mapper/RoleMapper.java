package com.ian.mapper;

import com.ian.pojo.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有的角色
     * @return
     */
    @Select("select * from role where role_state = 1")
    List<Role> selectRoleAll();

    /**
     * 通过用户id查询出来该用户所有的角色
     * @param userId
     * @return
     */
    List<Role> selectUserRoleListByUserId(Integer userId);

    /**
     * 通过角色名称查询角色id
     * @param roleName
     * @return
     */
    Integer selectRoleIdByRoleName(String roleName);

    /**
     * 查询所有的角色,并且把角色的创建人也查询出来
     * @return
     */
    List<Role> selectRoleAllAndCreateName(Role role);
}