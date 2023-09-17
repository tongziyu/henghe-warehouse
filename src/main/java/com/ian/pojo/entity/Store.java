package com.ian.pojo.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 仓库表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer storeId;

    private String storeName;

    private String storeNum;

    private String storeAddress;

    private String concat;

    private String phone;

}