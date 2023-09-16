package com.ian.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
    * 角色表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private String roleCode;

    /**
    * 1 启用 0 禁用
    */
    private String roleState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;


}