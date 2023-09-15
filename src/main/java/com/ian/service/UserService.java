package com.ian.service;

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

    UserQueryPageVO getUserList(UserQueryPageDTO userQueryPageDTO);
}
