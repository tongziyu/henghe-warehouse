package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.PurchasePageDTO;
import com.ian.pojo.entity.BuyList;
import com.ian.pojo.vo.PurchasePageVO;
import com.ian.pojo.vo.PurchaseQueryPageVo;
import com.ian.service.BuyListService;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    /**
     * 修改采购单
     * @return
     */
    @PutMapping("/purchase-update")
    public Result updatePurchase(@RequestBody BuyList buyList){
        log.info("修改采购单:{}",buyList);
        buyListService.updatePurchase(buyList);
        return Result.ok();
    }

    /**
     * 生成入库单
     */
    @PostMapping("/in-warehouse-record-add")
     public Result inWarehouseRecordAdd(){

        return null;
    }

}
