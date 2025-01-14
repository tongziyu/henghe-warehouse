package com.ian.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 采购单
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyList implements Serializable {
    private Integer buyId;

    private Integer productId;

    private Integer storeId;

    private Integer buyNum;

    private Integer factBuyNum;


    private String buyTime;

    private Integer supplyId;

    private Integer placeId;

    private String buyUser;

    private String phone;

    /**
    * 0 否 1 是
    */
    private String isIn;

    private static final long serialVersionUID = 1L;

    // 追加数据 ====================>

    private String storeName;

    private String productName;

}