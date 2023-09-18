package com.ian.pojo.vo;

import com.ian.pojo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 00:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseQueryPageVo {
    private Long totalNum;

    private List<PurchasePageVO> resultList;
}
