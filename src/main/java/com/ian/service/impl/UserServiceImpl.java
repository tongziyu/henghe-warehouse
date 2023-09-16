package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.constant.MessageConstant;
import com.ian.exception.UserException;
import com.ian.mapper.UserMapper;
import com.ian.pojo.dto.UserAddDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.User;
import com.ian.pojo.vo.UserQueryPageVO;
import com.ian.service.UserService;
import com.ian.utils.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

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

    /**
     * 通过账号查询user
     * @param userCode
     * @return
     */
    @Override
    public User selectByUserCode(String userCode) {
        return userMapper.selectByUserCode(userCode);
    }

    /**
     * 分页查询,按条件查询
     *  userCode=       &userType=      &userState=      &pageSize=5   &pageNum=1   &totalNum=0
     * @param userQueryPageDTO
     * @return
     */
    @Override
    public UserQueryPageVO getUserList(UserQueryPageDTO userQueryPageDTO) {
        // 开启分页查询
        PageHelper.startPage(userQueryPageDTO.getPageNum(), userQueryPageDTO.getPageSize());
        User user = new User();
        BeanUtils.copyProperties(userQueryPageDTO,user);

        log.info("查询条件:{}",user);

        List<User> users = userMapper.selectUserList(user);

        PageInfo pageInfo = new PageInfo(users);

        UserQueryPageVO userQueryPageVO = new UserQueryPageVO();

        userQueryPageVO.setTotalNum(pageInfo.getTotal());

        userQueryPageVO.setResultList(pageInfo.getList());


        return userQueryPageVO;
    }

    /**
     * 添加用户
     */
    @Override
    public void addUser(User user) {
        User user1 = userMapper.selectUserByUserCode(user.getUserCode());
        // 如果数据库里面有该 用户名,则直接抛出异常
        if (user1 != null){
            throw new UserException(MessageConstant.USER_CODE_EXISTS);
        }
        userMapper.insert(user);
    }
}
