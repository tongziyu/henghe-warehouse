package com.ian.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 23:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasePageVO {
    private Integer buyId;

    private String storeName;

    private String productName;

    private Integer buyNum;

    private Integer factBuyNum;

    private String buyUser;

    private Date buyTime;

    private String phone;

    private String isIn;
}
