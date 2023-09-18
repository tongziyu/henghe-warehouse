package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.entity.BuyList;
import com.ian.service.BuyListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 添加采购单
     */
    @PostMapping("/purchase-add")
    public Result addPurchase(@RequestBody BuyList buyList){
        log.info("采购单信息:{}",buyList);

        buyListService.addPurchase(buyList);
        return Result.ok("添加采购单成功");
    }

}
