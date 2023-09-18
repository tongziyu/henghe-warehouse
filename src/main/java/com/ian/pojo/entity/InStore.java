package com.ian.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 入库单
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InStore implements Serializable {
    private Integer insId;

    private Integer storeId;

    private Integer productId;

    private Integer inNum;

    private Integer createBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
    * 0 否 1 是
    */
    private String isIn;

    private static final long serialVersionUID = 1L;

    // 追加属性===================>
    private String storeName;

    private String productName;

    private String userCode;

    private BigDecimal inPrice;

}