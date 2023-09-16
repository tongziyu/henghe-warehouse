package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 17:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private Integer userId;
    private String userCode;
    private String userName;
}
