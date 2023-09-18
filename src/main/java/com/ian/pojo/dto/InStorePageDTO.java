package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 01:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InStorePageDTO {
    private Integer storeId;
    private String productName;
    private String startTime;
    private String endTime;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalNum;
}
