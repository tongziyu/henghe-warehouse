package com.ian.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
    * 角色表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    private LocalDateTime createTime;

    private Integer updateBy;

    private LocalDateTime updateTime;

    private String getCode;
}