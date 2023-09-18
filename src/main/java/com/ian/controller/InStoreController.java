package com.ian.controller;

import com.ian.pojo.Result;
import com.ian.pojo.dto.InStorePageDTO;
import com.ian.pojo.entity.InStore;
import com.ian.pojo.vo.InStorePageVo;
import com.ian.service.InStoreService;
import com.ian.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/19 01:00
 */
@RestController
@Slf4j
@RequestMapping("/instore")
public class InStoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private InStoreService inStoreService;

    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/store-list")
    public Result storeList(){
        return Result.ok(storeService.selectStoreList());
    }

    /**
     * 入库分页查询
     * /instore-page-list?
     * storeId=1    &productName=     &startTime=      &endTime=    &pageSize=5
     * &pageNum=1   &totalNum=0
     */
    @GetMapping("/instore-page-list")
    public Result inStorePageList(InStorePageDTO inStorePageDTO){
        log.info("入库分页查询:{}",inStorePageDTO);
        InStorePageVo inStorePageVo = inStoreService.QueryInStorePage(inStorePageDTO);

        return Result.ok(inStorePageVo);
    }

    /**
     * 确认入库
     * @return
     */
    @PutMapping("/instore-confirm")
    public Result inStoreConfirm(@RequestBody InStore inStore){
        inStoreService.updateConfirm(inStore);
        return Result.ok("入库成功!!!");
    }

}
