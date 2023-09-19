package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 12:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutStorePageDTO {
    private Integer storeId;
    private String productName;
    private String startTime;
    private String endTime;
    private Integer isOut;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalNum;

}
