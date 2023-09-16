package com.ian.pojo.vo;

import com.ian.pojo.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryPageVo {
    private Long totalNum;

    private List<Role> resultList;
}
