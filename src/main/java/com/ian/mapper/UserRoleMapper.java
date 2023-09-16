package com.ian.mapper;

import com.ian.pojo.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

    void deleteByUserId(Integer userId);

    /**
     * 插入数据
     * @param userRole
     */
    @Insert("insert into user_role(role_id, user_id) values (#{roleId},#{userId}) ")
    void insert(UserRole userRole);
}
