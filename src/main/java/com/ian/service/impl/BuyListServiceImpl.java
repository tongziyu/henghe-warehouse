package com.ian.service.impl;

import com.ian.mapper.BuyListMapper;
import com.ian.pojo.entity.BuyList;
import com.ian.service.BuyListService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ByteList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 18:24
 */
@Service
@Slf4j
public class BuyListServiceImpl implements BuyListService {

    @Autowired
    private BuyListMapper buyListMapper;

    /**
     * 添加采购单
     * @param buyList
     */
    @Override
    public void addPurchase(BuyList buyList) {
        buyList.setIsIn("0");

        buyList.setFactBuyNum(buyList.getBuyNum());

        buyListMapper.addPurchase(buyList);

    }
}
