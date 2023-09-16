package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
}
