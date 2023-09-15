package com.ian.mapper;

import com.ian.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where user_code = #{userCode} and is_delete = 0")
    User selectByUserCode(String userCode);
}
