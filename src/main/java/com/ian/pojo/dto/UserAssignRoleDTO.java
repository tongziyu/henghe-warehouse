package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 15:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAssignRoleDTO {
    private Integer userId;

    private List<String> roleCheckList;

}
