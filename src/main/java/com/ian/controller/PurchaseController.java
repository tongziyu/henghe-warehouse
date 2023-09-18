package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import com.ian.pojo.vo.PurchaseQueryPageVo;
import com.ian.service.BuyListService;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 18:13
 */
@RestController
@RequestMapping("/purchase")
@Slf4j
public class PurchaseController {

    @Autowired
    private BuyListService buyListService;

    @Autowired
    private StoreService storeService;

    /**
     * 添加采购单
     */
    @PostMapping("/purchase-add")
    public Result addPurchase(@RequestBody BuyList buyList){
        log.info("采购单信息:{}",buyList);

        buyListService.addPurchase(buyList);
        return Result.ok("添加采购单成功");
    }

    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/store-list")
    public Result storeList(){
        return Result.ok(storeService.selectStoreList());
    }


    /**
     * 分页查询采购单
     * storeId=1        &startTime=        &endTime=          &productName=         &buyUser=&
     * isIn=        &pageSize=5       &pageNum=1    &totalNum=0
     * @return
     */
    @GetMapping("/purchase-page-list")
    public Result purchasePageList( PurchasePageDTO purchasePageDTO){
        log.info("采购单分页查询:{}",purchasePageDTO);

        PurchaseQueryPageVo purchaseQueryPageVo = buyListService.QueryPurchasePage(purchasePageDTO);
        return Result.ok(purchaseQueryPageVo);
    }

}
