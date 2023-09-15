package com.ian.mapper;

import com.ian.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where user_code = #{userCode} and is_delete = 0")
    User selectByUserCode(String userCode);

    List<User> selectUserList(User user);
}
