package com.ian.pojo.vo;

import com.ian.pojo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 01:14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserQueryPageVO {
    private Long totalNum;

    private List<User> resultList;
}
