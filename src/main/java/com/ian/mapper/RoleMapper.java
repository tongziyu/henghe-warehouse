package com.ian.mapper;

import com.ian.pojo.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 更新角色的状态
     * @param role
     */
    @Update("update role set role_state = #{roleState},update_by = #{updateBy},update_time=#{updateTime} " +
            "where role_id = #{roleId}")
    void updateRoleState(Role role);

    /**
     * 通过角色的名字进行查询
     * @param roleName
     * @return
     */
    @Select("select * from role where role_name = #{roleName} and role_state = 1")
    Role selectRoleByRoleName(String roleName);

    /**
     * 通过角色的代码进行查询
     * @param roleCode
     * @return
     */
    @Select("select * from role where role_code = #{roleCode} and role_state = 1")
    Role selectRoleByRoleCode(String roleCode);

    /**
     * 插入角色
     * @param role
     */
    void insert(Role role);
}