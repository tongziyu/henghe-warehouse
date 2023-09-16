package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 17:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryPageDTO {
    private String roleName;

    private String roleCode;

    private String roleState;

    private Integer pageSize;

    private Integer pageNum;

    private Integer totalNum;
}
