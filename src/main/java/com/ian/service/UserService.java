package com.ian.service;

import com.ian.pojo.dto.UserAddDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.User;
import com.ian.pojo.vo.UserQueryPageVO;

import java.util.List;

public interface UserService {

    /**
     * 通过账号查询user
     * @param userCode
     * @return
     */
    User selectByUserCode(String userCode);

    /**
     * 分页查询,根据条件
     * @param userQueryPageDTO
     * @return
     */
    UserQueryPageVO getUserList(UserQueryPageDTO userQueryPageDTO);

    /**
     * 添加用户
     *
     */
    void addUser(User user);
}
