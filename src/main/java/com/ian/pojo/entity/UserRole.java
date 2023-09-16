package com.ian.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer userRoleId;

    private Integer roleId;

    private Integer userId;
}
