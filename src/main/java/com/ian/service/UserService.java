package com.ian.service;

import com.ian.pojo.entity.User;

public interface UserService {


    User selectByUserCode(String userCode);
}
