package com.ian.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 出库单
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutStore implements Serializable {
    private Integer outsId; // 出库单

    private Integer productId; //产品ID

    private Integer storeId; // 仓库ID

    private Integer tallyId; // 理货员ID

    private BigDecimal outPrice; // 出库价格

    private Integer outNum; // 出库数量

    private Integer createBy; // 创建人id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间

    /**
    * 0 否 1 是
    */
    private String isOut; // 是否已出库

    private static final long serialVersionUID = 1L;

    // 追加属性

    private BigDecimal salePrice;

    private String storeName;

    private String productName;

    private String userCode;

    private String tallyCode;
}