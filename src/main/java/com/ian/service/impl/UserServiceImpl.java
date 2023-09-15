package com.ian.service.impl;

import com.ian.mapper.UserMapper;
import com.ian.pojo.entity.User;
import com.ian.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 18:11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserCode(String userCode) {
        return userMapper.selectByUserCode(userCode);
    }
}
