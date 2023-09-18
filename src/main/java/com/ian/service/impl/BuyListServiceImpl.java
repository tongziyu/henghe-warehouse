package com.ian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ian.mapper.BuyListMapper;
import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import com.ian.pojo.vo.PurchaseQueryPageVo;
import com.ian.service.BuyListService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ByteList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询所有的订单 按条件
     * @param purchasePageDTO
     * @return
     */
    @Override
    public PurchaseQueryPageVo QueryPurchasePage(PurchasePageDTO purchasePageDTO) {
        PageHelper.startPage(purchasePageDTO.getPageNum(),purchasePageDTO.getPageSize());

        List<PurchasePageVO> purchasePageVOS = buyListMapper.selectPurchasePage(purchasePageDTO);

        PageInfo pageInfo = new PageInfo(purchasePageVOS);

        PurchaseQueryPageVo purchaseQueryPageVo = new PurchaseQueryPageVo();

        purchaseQueryPageVo.setTotalNum(pageInfo.getTotal());

        purchaseQueryPageVo.setResultList(pageInfo.getList());
        return purchaseQueryPageVo;
    }
}
