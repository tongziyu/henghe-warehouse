package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/17 15:17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPageDTO {
    /*
    http://localhost:3000/api/product/product-page-list?
        storeId=1&productName=&brandName=&typeName=&supplyName=&
        placeName=&upDownState=&isOverDate=&pageSize=5&pageNum=1&totalNum=0&
     */
    private Integer storeId;
    private String productName;
    private String brandName;
    private String typeName;
    private String supplyName;
    private String placeName;
    private Integer upDownState;
    private Integer isOverDate;
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalNum;
}
