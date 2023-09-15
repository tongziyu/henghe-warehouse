package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 00:52
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserQueryPageDTO implements Serializable {

    private String userCode;

    private Integer userType;

    private String userState;

    private Integer pageSize;

    private Integer pageNum;

    private Integer totalNum;

}
