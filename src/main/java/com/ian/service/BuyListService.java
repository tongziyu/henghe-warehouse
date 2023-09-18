package com.ian.service;

import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import com.ian.pojo.vo.PurchaseQueryPageVo;

import java.util.List;

public interface BuyListService {
    /**
     * 添加采购单
     * @param buyList
     */
    void addPurchase(BuyList buyList);

    /**
     * 分页查询所有的订单 按条件
     * @param purchasePageDTO
     * @return
     */
    PurchaseQueryPageVo QueryPurchasePage(PurchasePageDTO purchasePageDTO);
}
