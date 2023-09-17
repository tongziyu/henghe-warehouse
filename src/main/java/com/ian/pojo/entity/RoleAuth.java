package com.ian.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 23:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuth {
    private Integer roleAuthId;
    private Integer roleId;
    private Integer authId;
}
