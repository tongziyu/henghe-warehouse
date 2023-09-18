package com.ian.mapper;

import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyListMapper {
    /**
     * 添加采购单
     * @param buyList
     */
    void addPurchase(BuyList buyList);

    List<PurchasePageVO> selectPurchasePage(PurchasePageDTO purchasePageDTO);
}