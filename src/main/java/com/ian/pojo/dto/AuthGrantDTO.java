package com.ian.pojo.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 23:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthGrantDTO {
    private List<Integer> authIds;

    private Integer roleId;
}
