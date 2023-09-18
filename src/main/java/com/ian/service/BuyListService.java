package com.ian.service;

import com.ian.pojo.entity.BuyList;

public interface BuyListService {
    /**
     * 添加采购单
     * @param buyList
     */
    void addPurchase(BuyList buyList);
}
