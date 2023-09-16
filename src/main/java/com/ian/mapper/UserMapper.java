package com.ian.mapper;

import com.ian.pojo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where user_code = #{userCode} and is_delete = 0")
    User selectByUserCode(String userCode);

    List<User> selectUserList(User user);

    /**
     * 新增用户
     * @param user
     */
    void insert(User user);

    /**
     * 根据user_code查询用户
     * @param userCode
     * @return
     */
    @Select("select * from user_info where user_code = #{userCode} and is_delete = 0")
    User selectUserByUserCode(String userCode);

    /**
     * 修改用户的状态
     * @param user
     */
    void updateStateByUserId(User user);

    /**
     * 删除用户, 实际上是把is_delete字段修改成1
     * @param user
     */
    void deleteUserByUserId(User user);

    /**
     * 修改用户昵称
     * @param user
     */
    void updateUser(User user);
}
