package com.ian.mapper;

import com.ian.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {
    /**
     * 根据userId查询权限菜单
     * @param userId
     * @return
     */
    List<Auth> selectAuthByUserId(Integer userId);

}
