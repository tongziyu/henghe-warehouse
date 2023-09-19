package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 14:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorePageDTO {
    private String storeName;
    private String storeAddress;
    private String concat;
    private String phone;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalNum;
}
