package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 19:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateDTO {
    private String roleName;

    private String roleDesc;

    private Integer roleId;
}
