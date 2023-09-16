package com.ian.service;

import com.ian.pojo.dto.UserAddDTO;
import com.ian.pojo.dto.UserAssignRoleDTO;
import com.ian.pojo.dto.UserQueryPageDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.entity.User;
import com.ian.pojo.vo.UserQueryPageVO;
import com.ian.utils.CurrentUser;


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

    /**
     * 修改用户状态
     * @param user
     */
    void updateStateByUserId(User user);

    /**
     * 通过用户id查询出来该用户的所有的角色
     * @param userId
     * @return
     */
    List<Role> getUserRoleListByUserId(Integer userId);


    /**
     * 给用户分配角色
     * @param userAssignRoleDTO
     */
    void assignRole(UserAssignRoleDTO userAssignRoleDTO);

    /**
     * 删除用户, 实际上是把is_delete字段修改成1
     * @param user
     */
    void deleteUserByUserId(User user);

    /**
     * 批量删除用户
     * @param userIds
     * @param currentUser
     */
    void deleteUserBatch(List<Integer> userIds, CurrentUser currentUser);

    /**
     * 修改员工信息 (只能修改userName)
     * @param user
     */
    void updateUser(User user);

    /**
     * 重置用户密码
     * @param user
     */
    void updateUserPwd(User user);
}
