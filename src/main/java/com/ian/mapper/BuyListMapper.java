package com.ian.mapper;

import com.ian.pojo.entity.BuyList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyListMapper {
    /**
     * 添加采购单
     * @param buyList
     */
    void addPurchase(BuyList buyList);
}