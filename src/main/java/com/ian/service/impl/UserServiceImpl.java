package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.constant.MessageConstant;
import com.ian.exception.UserException;
import com.ian.mapper.RoleMapper;
import com.ian.mapper.UserMapper;
import com.ian.mapper.UserRoleMapper;
import com.ian.pojo.dto.UserAssignRoleDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.entity.User;
import com.ian.pojo.entity.UserRole;
import com.ian.pojo.vo.UserQueryPageVO;
import com.ian.service.UserService;
import com.ian.utils.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;


import java.time.LocalDateTime;
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

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
    /**
     * 修改用户状态
     * @param user
     */
    @Override
    public void updateStateByUserId(User user) {
       userMapper.updateStateByUserId(user);

    }

    /**
     * 通过用户id查询出来该用户的所有的角色
     * @param userId
     * @return
     */
    @Override
    public List<Role> getUserRoleListByUserId(Integer userId) {
        List<Role> roleList = roleMapper.selectUserRoleListByUserId(userId);

        return roleList;
    }

    /**
     * 给用户分配角色
     * 添加事务
     * @param userAssignRoleDTO
     */
    @Override
    @Transactional
    public void assignRole(UserAssignRoleDTO userAssignRoleDTO) {
        /**
         * 思路:
         *      - 先通过userId删除该用户所有的角色,在插入角色
         *      - 通过list里面的roleCheckList 查询出 对应角色的id
         *      - 向User_role 表里面插入数据
         */
        // 删除该userId所有的角色
        userRoleMapper.deleteByUserId(userAssignRoleDTO.getUserId());

        List<String> roleCheckList = userAssignRoleDTO.getRoleCheckList();
        for (String rc : roleCheckList){
            UserRole userRole = new UserRole();
            Integer roleId = roleMapper.selectRoleIdByRoleName(rc);
            userRole.setRoleId(roleId);
            userRole.setUserId(userAssignRoleDTO.getUserId());
            userRoleMapper.insert(userRole);
        }
    }

    /**
     * 删除用户, 实际上是把is_delete字段修改成1
     * @param user
     */
    @Override
    public void deleteUserByUserId(User user) {
        /*
        思路:
            - 删除用户的时候用将对应的 is_delete数据修改为1
         */
        userMapper.deleteUserByUserId(user);
    }

    /**
     * 批量删除用户  实际上是把is_delete字段修改成1
     * @param userIds
     * @param currentUser
     */
    @Override
    @Transactional
    public void deleteUserBatch(List<Integer> userIds, CurrentUser currentUser) {
        /*
        思路:
            - 删除用户的时候用将对应的 is_delete数据修改为1
         */
        for (Integer userId: userIds){
            // 封装数据
            User user = new User();
            user.setIsDelete("1");
            user.setUpdateTime(LocalDateTime.now());
            user.setUpdateBy(currentUser.getUserId());
            user.setUserId(userId);
            // 删除该用户
            userMapper.deleteUserByUserId(user);
        }
    }

    /**
     * 修改员工信息 (只能修改userName)
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateUserName(user);
    }

    /**
     * 重置用户密码
     * @param user
     */
    @Override
    public void updateUserPwd(User user) {
        userMapper.updateUserPwd(user);
    }
}
