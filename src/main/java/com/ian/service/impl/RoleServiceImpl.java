package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.constant.MessageConstant;
import com.ian.exception.RoleException;
import com.ian.mapper.RoleMapper;
import com.ian.pojo.dto.RoleQueryPageDTO;
import com.ian.pojo.entity.Role;
import com.ian.pojo.vo.RoleQueryPageVo;
import com.ian.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 14:44
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取所有的角色信息
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleMapper.selectRoleAll();
        return roleList;
    }

    /**
     * 分页查询角色
     * @param roleQueryPageDTO
     * @return
     */
    @Override
    public RoleQueryPageVo getRolePageList(RoleQueryPageDTO roleQueryPageDTO) {
        // 开启分页查询
        PageHelper.startPage(roleQueryPageDTO.getPageNum(),roleQueryPageDTO.getPageSize());

        Role role = Role
                .builder()
                .roleName(roleQueryPageDTO.getRoleName())
                .roleCode(roleQueryPageDTO.getRoleCode())
                .roleState(roleQueryPageDTO.getRoleState())
                .build();

        log.info("模糊查询的role:{}",role);

        List<Role> roleList = roleMapper.selectRoleAllAndCreateName(role);

        PageInfo pageInfo = new PageInfo(roleList);

        RoleQueryPageVo roleQueryPageVo = new RoleQueryPageVo();

        roleQueryPageVo.setTotalNum(pageInfo.getTotal());

        roleQueryPageVo.setResultList(pageInfo.getList());

        return roleQueryPageVo;
    }

    /**
     * 修改状态
     * @param role
     */
    @Override
    public void updateRoleState(Role role) {
        roleMapper.updateRoleState(role);
    }

    /**
     * 添加角色
     * @param role
     */
    @Override
    public void addRole(Role role) {
        /*
        思路:
            - 查询名称,如果数据库里面有,这抛出异常
            - 查询代码,如果数据库里面有,则抛出异常
            - 如果都没有,则将role保存进数据库
         */
        Role role1 = roleMapper.selectRoleByRoleName(role.getRoleName());

        if (role1 != null){
            throw new RoleException(MessageConstant.ROLE_NAME_EXISTS);
        }

        Role role2 = roleMapper.selectRoleByRoleCode(role.getRoleCode());
        if (role2 != null){
            throw new RoleException(MessageConstant.ROLE_CODE_EXISTS);
        }

        // 插入数据
        roleMapper.insert(role);
    }

    /**
     * 更新角色描述信息
     * @param role
     */
    @Override
    public void updateRoleDesc(Role role) {
        roleMapper.updateRoleDesc(role);
    }

    /**
     * 根据id删除role
     * @param roleId
     */
    @Override
    public void deleteRoleByRoleId(Integer roleId) {
        roleMapper.deleteRoleByRoleId(roleId);
    }
}
