package com.ian.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    private Integer storeId;//仓库id

    private String storeName;//仓库名称

    private Integer totalInvent;//仓库商品库存数
}
