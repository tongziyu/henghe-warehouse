package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 01:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddDTO {
    private String userCode;

    private String userName;

    private String userPwd;

}
